class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]<nums[mid+1])
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        return low;
    }
}
/*arr = [3, 2, 1]
mid = 1, arr[mid] = 2
arr[mid] > arr[mid+1] → 2 > 1 ✅
But peak is at index 0, not index 1
*/