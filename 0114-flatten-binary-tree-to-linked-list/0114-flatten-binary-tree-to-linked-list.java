class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null) {
            
            if(curr.left != null) {
                // find rightmost node of left subtree
                TreeNode prev = curr.left;
                while(prev.right != null) {
                    prev = prev.right;
                }
                
                // connect rightmost of left to curr's right
                prev.right = curr.right;
                
                // move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }
            
            curr = curr.right;
        }
    }
}