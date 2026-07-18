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
    int maxDiameter = 0;
    public int height(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int a = height(root.left);
        int b = height(root.right);
        maxDiameter = Math.max(maxDiameter, a+b);
        return 1 + Math.max(a,b); 
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }
}