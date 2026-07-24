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
    long prev =Long.MIN_VALUE;
    boolean ans = true;
    public void helper(TreeNode root)
    {
        if(root == null) return;
        helper(root.left);
        if(root.val<prev || root.val == prev)
        { 
          ans=false;
          return;
        }
        prev = root.val;
        helper(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return ans;
    }
}