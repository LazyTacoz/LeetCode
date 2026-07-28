class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void helper(int f, int n, int k, List<Integer>list)
    {
        if(list.size() == k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=f ; i<=n; i++)
        {
            list.add(i);
            helper(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> l = new ArrayList<>();
        helper(1,n,k,l);
        return ans;

    }
}