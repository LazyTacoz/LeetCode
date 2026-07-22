class Solution {

    int max = 0;
    int count = 0;
    Integer prev = null;

    List<Integer> ans = new ArrayList<>();

    public void inorder(TreeNode root)
    {
        TreeNode curr = root;

        while(curr != null)
        {
            if(curr.left == null)
            {
                process(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode ipre = ipre(curr);

                if(ipre.right == null)
                {
                    ipre.right = curr;
                    curr = curr.left;
                }
                else
                {
                    ipre.right = null;
                    process(curr.val);
                    curr = curr.right;
                }
            }
        }
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

    public TreeNode ipre(TreeNode node)
    {
        TreeNode prev = node.left;

        while(prev.right != null && prev.right != node)
        {
            prev = prev.right;
        }

        return prev;
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