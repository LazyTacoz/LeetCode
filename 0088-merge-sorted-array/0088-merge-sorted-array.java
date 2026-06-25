class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int size = 0;
        int [] arr = new int[m+n];
        while(left<m && right<n)
        {
            if(nums1[left]<=nums2[right])
            {
                arr[size] = nums1[left];
                left++;
                size++;
            }
            else
            {
                arr[size] = nums2[right];
                right++;
                size++;
            }
        }
        while(left<m)
        {
            arr[size] = nums1[left];
            left++;
            size++;
        }
        while(right<n)
        {
            arr[size] = nums2[right];
            right++;
            size++;
        }
        for(int i=0;i<m+n;i++)
        {
            nums1[i] = arr[i];
        }
    }
}