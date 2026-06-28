class Solution {
    public int nthUglyNumber(int n) {
        // min heap 
        //set for no duplis 
        // 1 is fix put in min heap
        // minheap.poll();
        // minheap.poll*2, *3 *5 
        if(n==1)
        {
            return 1;
        }
        PriorityQueue <Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.add((long)1);
        set.add((long)1);
        for(int i=1; i<n; i++)
        {
            Long temp = heap.poll();
            if(!set.contains(temp*2))
            {
                heap.add(temp*2L);
                set.add(temp*2L);
            }
            if(!set.contains(temp*3))
            {
                heap.add(temp*3L);
                set.add(temp*3L);
            }
            if(!set.contains(temp*5))
            {
                heap.add(temp*5L);
                set.add(temp*5L);
            }
        }
        return heap.peek().intValue();
    
    } 
}