class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // distance , x,y
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0; i<k; i++)
        {
            int x = points[i][0];
            int y = points[i][1];
           heap.offer(new int[]{x*x+y*y,x,y});
        }
        for(int i=k; i<points.length; i++)
        {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x+y*y;
            if(dist<heap.peek()[0])
            {
                heap.poll();
                heap.offer(new int[]{dist,x,y});
            }
        }
        int [][] res = new int[heap.size()][2];
        int x = heap.size();
        for(int i=0; i<x ; i++) //  cant do i<heap.size() as it changes everytime
        {
            int [] temp = heap.poll();
            res[i] = new int[]{temp[1],temp[2]};
        }
        return res;
    }
}