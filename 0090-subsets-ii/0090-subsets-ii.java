class Solution {
    List<List<Integer>>ans  = new ArrayList<>();
    public void helper(int[] nums,List<Integer>curr,int index)
    {
        ans.add(new ArrayList<>(curr));
        
        for(int i=index;i<nums.length;i++)
        {
            if(i > index && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(nums,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums); 
        helper(nums,curr,0);
        return ans;
    }
}