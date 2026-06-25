class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]>heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0; i<matrix.length;i++)
        {
            heap.add(new int[]{matrix[i][0],i,0});
        }
        int size =0;
        int []arr = new int[k];
        while(!heap.isEmpty())
        {
            
            if(size == k)
            {
                break;
            }
            arr = heap.poll();
            int val = arr[0];
            int list = arr[1];
            int index = arr[2];
            size++;
            if(index+1<matrix[list].length)
            {
                heap.add(new int[]{matrix[list][index+1],list,index+1});
            }
        }
        return arr[0];
    }
}