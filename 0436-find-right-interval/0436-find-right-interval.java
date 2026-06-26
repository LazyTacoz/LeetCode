class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] arr = new int[intervals.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = -1;
        }
        PriorityQueue<int[]> heap_start = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> heap_end = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<intervals.length;i++)
        {
            heap_start.add(new int[]{intervals[i][0],i});
            heap_end.add(new int[]{intervals[i][1],i});
        }
        while(!heap_start.isEmpty() && !heap_end.isEmpty())
        {
            int temp[] = heap_end.poll();
            int end  = temp[0];
            while(!heap_start.isEmpty() && end > heap_start.peek()[0])
            {
                heap_start.poll();
            }
            
            if(!heap_start.isEmpty())
            {
                arr[temp[1]] = heap_start.peek()[1];
            }
        }
        return arr;
    }
}