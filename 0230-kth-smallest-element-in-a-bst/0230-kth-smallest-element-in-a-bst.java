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
    int count= 1;
    public Integer helper(TreeNode root,int k)
    {
        if(root == null) return null;
        Integer left = helper(root.left, k);
        if (left != null) return left;
        if(count == k) return root.val ;
        count++;
        return helper(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
       return helper(root,k);
    }
}