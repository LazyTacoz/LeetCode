class Solution {
    public boolean possible(int arr_sum ,int[] nums, int k)
    {
        int sum = 0;
        int count = 1;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>arr_sum)
            {
                sum = nums[i];
                count++;
            }
        }
        return count<=k;
    }
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int low = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            low = Math.max(low,nums[i]);
        }
        int high = sum;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(possible(mid, nums,k))
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
}