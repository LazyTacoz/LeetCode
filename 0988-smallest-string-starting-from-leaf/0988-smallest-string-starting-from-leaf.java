class Solution {
    String result = null;
    
    public void helper(TreeNode root, String s) {
        if(root == null) return;
        
        s = (char)('a' + root.val) + s;  // prepend current node
        
        if(root.left == null && root.right == null) {
            // leaf node — compare with result
            if(result == null || s.compareTo(result) < 0) {
                result = s;
            }
            return;
        }
        
        helper(root.left, s);
        helper(root.right, s);
    }
    
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return result;
    }
}