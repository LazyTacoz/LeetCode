class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        // TO OPTIMIZE  have to create minheap for capital->profit
        // maxheap for geeting max prfit 
        int arr[][] = new int[capital.length][2];
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<profits.length; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        int temp = -1;
        for(int i=0; i<k; i++)
        {
            while(temp+1 < profits.length && arr[temp+1][1] <= w)
            {
                temp++;
                maxheap.add(arr[temp][0]);
                
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