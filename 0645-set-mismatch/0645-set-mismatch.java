class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i<nums.length)
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
        for(int j = 0; j<nums.length; j++)
        {
            int correct_index = nums[j];
            if(nums[j] != j+1)
            {
                return new int[]{nums[j], j+1};
            }
        }
        return new int[]{};
    }
}