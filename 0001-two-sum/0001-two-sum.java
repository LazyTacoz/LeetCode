class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length; i++)
        {
            int TWO_TARGET = target-nums[i];
            if(map.containsKey(TWO_TARGET))
            {
                return(new int[]{i,map.get(TWO_TARGET)});
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}