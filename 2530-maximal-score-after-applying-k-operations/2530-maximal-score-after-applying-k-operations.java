class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++)
        {
            heap.offer((long)nums[i]);
        }
        for(int i=0; i<k; i++)
        {
            long temp = heap.poll();
            score+=temp;
            heap.add((long)Math.ceil((temp*1.0)/3.0));
        }
        return score;
    }
}