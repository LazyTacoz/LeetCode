class Solution {
    List<List<Integer>> ans  = new ArrayList<>();
    public void helper(int[] nums,List<Integer> list,boolean[] used)
    {
        if(list.size() == nums.length )
        {
            ans.add(new ArrayList<>(list));
        }
        for(int i= 0; i<nums.length; i++)
        {
            if(used[i]==true) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(nums,list,used);
            list.remove(list.size()-1); // undo choice
            used[i] = false;
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,list,used);
        return ans;
    }
}