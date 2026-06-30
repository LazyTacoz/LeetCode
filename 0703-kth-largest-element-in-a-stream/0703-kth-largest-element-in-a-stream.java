class KthLargest {
    int kth;
    PriorityQueue <Integer> heap;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<Integer>();
        kth = k;
        for(int i=0; i<nums.length; i++)
        {
            add(nums[i]);
        }
    }
    
    public int add(int val) {

        
        if(heap.size()<kth)
        {
            heap.add(val);
        }
        else if(val>heap.peek())
        {
            heap.poll();
            heap.add(val);
        }
        
        if(heap.size()==kth)
        {
            return heap.peek();
        }
        return 0;

    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */