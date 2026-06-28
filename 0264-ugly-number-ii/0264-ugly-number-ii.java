class Solution {
    public int nthUglyNumber(int n) {
       int[] dp = new int[n];
       int[] idx = new int[3];
       int[] primes = {2,3,5};
       dp[0] = 1;
       for(int i=1;i<n;i++)
       {
        int min = Integer.MAX_VALUE;
        for(int j=0; j<primes.length; j++)
        {
            min = Math.min(min,dp[idx[j]]*primes[j]);
        }
        dp[i] = min;
        for(int j=0; j<primes.length; j++)
        {
            if(min == dp[idx[j]]*primes[j])
            {
                idx[j]++;
            }
        }
             
       }
    return dp[n-1];   
    } 
}
/**
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
        return heap.peek().intValue(); */