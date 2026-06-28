class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // CREATE A ARRAY OF UGLY NUMBER 
        //CREATE A ARRAY FOR IDX .. LIKE WHICH IDX TO MULTIPLY 
        long[] dp = new long[n];
        dp[0] = 1;
        int[] idx = new int[primes.length];
        for(int i=1; i<n;i++) // this is for the ugly number which is is going to be entered on ith idx of array dp
        {
            long min =Long.MAX_VALUE;
            for(int j=0; j<primes.length;j++) // this forloop is for all the contestants of the minimum value 
            {
                min  = Math.min((long)dp[idx[j]]*primes[j],min);
            }
            dp[i] = min;
            for(int j=0; j<idx.length; j++) // this forloop is for duplicatre check 
            {
                if((long)dp[idx[j]]*primes[j] == min)
                {
                    idx[j]++;
                }
            }
        } 
        return (int) dp[n-1];
    }

}
/*
 // FIRST NO IS FIX THAT IS 1
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.add(1L);
        set.add(1L);
        for(int i=1; i<n;i++)
        {
            long temp = heap.poll();
            for(int j=0;j<primes.length;j++)
            {
                long next = temp * primes[j];
                if(set.add(next))
                {
                    heap.offer(next);
                }
            }
        }
        return heap.peek().intValue(); */