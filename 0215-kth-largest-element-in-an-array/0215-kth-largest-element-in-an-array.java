class Solution {
    public int findKthLargest(int[] nums, int k) {
        // make minheap
        //add first k numbers 
        // remove from minheap, add the next element 
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<k; i++)
        {
            heap.add(nums[i]);
        }
        for(int i=k; i<nums.length; i++)
        {
            heap.add(nums[i]);
            heap.poll();
        }
        
        return heap.poll();
    }

}