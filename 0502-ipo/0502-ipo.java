class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        // TO OPTIMIZE .we have to create maxheap for capital->profit
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[2];
        for(int i=0; i<capital.length;i++)
        {
            minheap.add(new int[]{capital[i],profits[i]});
        }
        for(int i=0; i<k; i++)
        {
            while(!minheap.isEmpty() && minheap.peek()[0]<=w)
            {
                maxheap.offer(minheap.poll()[1]);
            }
            if(maxheap.isEmpty())
            {
                break;
            }
            w+=maxheap.poll();
        }
        return w;
    }
}
//BRUTE FORCE
        //OUTER LOOP WILL RUN K TIMES (NO OF  PROJECTS THAT CAN BE DONE )
        //INNER LOOP HAS TO SCAN ENTIRE CAPITAL ARRAY , LOOKING FOR ELEMENT LESS THAN W AND CORRESPOMDIONG PROFIT FOR THAT AND MAINTAIN MAX TO GET THE MAXIMUM PROFIT 
        // have to remove the entry which is already processed
        //W =  W+MAX
/*for(int i=0; i<k; i++)
        {
            int max = 0;
            int idx =-1;
            for(int j=0; j<capital.length; j++)
            {
                if(capital[j] != -1 && capital[j]<=w)
                {
                    if(max<profits[j])
                    {
                        max = profits[j];
                        idx = j;
                    }
                } 
            }
            if(idx == -1)
            {
                break;
            }
            capital[idx] = -1;
            w+=max;
        }
        return w;
        */