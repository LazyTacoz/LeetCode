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
    int ans = Integer.MAX_VALUE;
    Integer prev = null;
    public void helper(int n)
    {
        if(prev == null) prev = n;
        else
        {
            if(Math.abs(n-prev)<ans) ans = n-prev;
            prev = n;
        }
    }
    public void helper2(TreeNode root)
    {
        if(root == null) return;
        helper2(root.left);
        helper(root.val);
        helper2(root.right);
    }
    public int getMinimumDifference(TreeNode root) 
    {
        helper2(root);
        return ans;
    }
}