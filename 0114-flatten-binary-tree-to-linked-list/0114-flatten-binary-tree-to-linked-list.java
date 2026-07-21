/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    public void preorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        queue.offer(root);
        preorder(root.left);
        preorder(root.right);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        preorder(root);
        TreeNode node  = queue.poll();
        node.left = null;
        node.right = null;
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            temp.left = null;
            temp.right = null;
            node.right = temp;
            node = temp;
        }
    }
}