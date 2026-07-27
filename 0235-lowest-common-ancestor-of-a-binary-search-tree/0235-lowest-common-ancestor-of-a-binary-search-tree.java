/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;
        TreeNode left = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);
        if(left == null && right == null) return null;
        if(left!=null && right!=null) return root;
        if(left != null && right == null) return left;
        if(left == null && right !=null) return right;
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }
}