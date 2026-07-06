class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        //1 1 2 3 3 4 4 8 8 9 9
        //0 1 2 3 4 5 6 7 8 9 10
        //          m
        // 
        // 3,3,7,7,10,11,11
        // 0 1 2 3 4 5 6 7
        //       m l     h
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]<nums[mid+1])
            {
                if(mid%2 == 0)
                {
                    // already occured(left side)
                    high = mid;
                }
                else
                {
                    // (right side )
                    low = mid+1;
                }

            }
            else
            {
             if(mid%2 == 0)
                {
                    // (right side )
                    low = mid+1;
                }
                else
                {
                    // already occured(left side)
                    high = mid;
                }   
            }
        }
        return nums[low];
    }
}