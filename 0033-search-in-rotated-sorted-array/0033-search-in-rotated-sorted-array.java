class Solution {
    public int search(int[] nums, int target) {
        //[4,5,6,7,0,1,2] target = 0;
        //         l m h
        // 1,3
        // m h
                
        int low  = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if (nums[low]<=nums[mid]) // sorted part is left 
            {
                if(nums[low]<= target && target<nums[mid])//number fits in this part ?
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else //sorted is right 
            {
                if(nums[mid]< target && target<=nums[high])//number fits in this part ?
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }

        }
        return -1;
        
    }
}