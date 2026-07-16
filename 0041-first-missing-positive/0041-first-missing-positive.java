class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length)
        {
            if(nums[i]>0 && nums[i]<=nums.length)
            {
                int correct_index = nums[i]-1;
                if(nums[i]!=nums[correct_index])
                {
                    int temp = nums[i];
                    nums[i] = nums[correct_index];
                    nums[correct_index] = temp;
                }
                else
                {
                    i++;
                }
            }
            else
            {
                i++;
            }
        }
        // 3 4 -1 1
        // 1 4 -1 3
        // 1 4 -1 3
        for(int j=0; j<nums.length;j++)
        {
            if(nums[j]!=j+1)
            {
                return j+1;
            }
        }
        return nums.length+1;
    }
}