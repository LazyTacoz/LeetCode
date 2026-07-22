class Solution {

    int max = 0;
    int count = 0;
    Integer prev = null;

    List<Integer> ans = new ArrayList<>();

    public void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        process(root.val);
        inorder(root.right);
    }
    public void process(int val)
    {
        if(prev == null || prev != val)
        {
            count = 1;
            prev = val;
        }
        else
        {
            count++;
        }

        if(count > max)
        {
            max = count;
            ans.clear();
            ans.add(val);
        }
        else if(count == max)
        {
            ans.add(val);
        }
    }
    public int[] findMode(TreeNode root)
    {
        inorder(root);

        int[] res = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++)
        {
            res[i] = ans.get(i);
        }

        return res;
    }
}