class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //1 -> soldiers
        //0 -> civilians
        // all 1s on left of 0s
        // row i weaker than row j when -> i(soldiers) < j(soldiers) OR (i(soldiers) = j(soldiers) AND i<j)
        // k weakest asked so have to use kth max element 
    
       // [[1,1,0,0,0],
       // [1,1,1,1,0],
       // [1,0,0,0,0],
       //[1,1,0,0,0],
       // [1,1,1,1,1]], 
       // (no_soldiers, i)

       PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> a[0] != b[0] ? b[0] -a[0] : b[1]-a[1]);
       for(int i=0; i<mat.length; i++)
       {
        int count = 0;
            for(int j=0; j<mat[i].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    break;
                }
                count++;
            }
            if(heap.size()<k)
            {
                heap.add(new int[]{count,i});
            }
            else if(heap.peek()[0]>count)
            {
                heap.poll();
                heap.add(new int[]{count,i});
            }
       }    
            int[] ans = new int[k];
            int x = k-1;
        while(!heap.isEmpty())
        {
            ans[x] = heap.poll()[1];
            x--;
        }
        return ans ;
       
    }
}