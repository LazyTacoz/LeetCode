class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        //val,index
        for(int i=0; i<nums.length; i++)
        {
            if(heap.size()<k)
            {
                heap.offer(new int[]{nums[i],i});
            }
            else if(nums[i]>heap.peek()[0])
            {
                heap.poll();
                heap.offer(new int[]{nums[i],i});
            }
        }
        int[][] res = new int[k][];
        for(int i=0; i<k; i++)
        {
            res[i] = heap.poll();
        }
        Arrays.sort(res,(a,b)->a[1]-b[1]);
        int[] ans = new int[k];
        for(int i=0;i<res.length;i++)
        {
            ans[i] = res[i][0];
        }
        return ans;
    }
}