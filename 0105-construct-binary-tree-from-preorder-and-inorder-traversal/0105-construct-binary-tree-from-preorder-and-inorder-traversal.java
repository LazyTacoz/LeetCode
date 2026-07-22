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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode helper(int prestart, int low, int high, int[] preorder,int[] inorder)
    {
        if(prestart>preorder.length-1 || low>high) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int mid = map.get(preorder[prestart]);
        root.left = helper(prestart+1,low,mid-1,preorder,inorder);
        root.right = helper(prestart + (mid-low) + 1,mid+1,high,preorder,inorder);  //Left subtree size = mid - low
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
}