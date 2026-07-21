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
    String ans = "~";
    public void helper(TreeNode root,String s)
    {
        if(root == null)
        {
            return;
        }
        s = (char)('a'+root.val)+s;
        if(root.left == null && root.right == null)
        {
            if(ans == null || ans.compareTo(s)>-1)
            {
                ans = s;
            }
            return;
        }
        helper(root.left,s);
        helper(root.right,s);
       
    }
    public String smallestFromLeaf(TreeNode root) {
        helper(root,"");
        return ans;
    }
}