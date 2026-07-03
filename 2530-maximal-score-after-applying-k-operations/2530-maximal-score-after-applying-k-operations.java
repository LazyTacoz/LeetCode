class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++)
        {
            heap.offer(nums[i]);
        }
        for(int i=0; i<k; i++)
        {
            int temp = heap.poll();
            score+=temp;
            heap.add((int)Math.ceil((temp*1.0)/3.0));
        }
        return score;
    }
}