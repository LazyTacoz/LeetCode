class Solution {
    public int first(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    public int last(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int start = first(nums,target);
        int finish = last(nums,target);
        return new int[]{start,finish};
    }
}