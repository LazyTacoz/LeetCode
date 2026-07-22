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
    public void helper(TreeNode root)
    {
        if(root == null) return;
       helper(root.left);
       map.put(root.val,map.getOrDefault(root.val,0)+1);
       helper(root.right);
    }
    public int[] findMode(TreeNode root) 
    {
        helper(root);
        int max = 0;
       for(Map.Entry<Integer,Integer> entry : map.entrySet())
       {
            max = Math.max(max,entry.getValue());
       }
       List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() == max)
            {
                list.add(entry.getKey());
            }
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
        {
            ans[i] = list.get(i);
        }

        return ans;
    }
}