class Solution {
    public int[] findRightInterval(int[][] intervals) {
        //start i unique
        int[] arr = new int[intervals.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = -1;
        }
        for(int i=0;i<intervals.length;i++)
        {
            int end = intervals[i][1];
            int min = Integer.MAX_VALUE;
            for(int j =0; j<intervals.length; j++)
            {
                int start = intervals[j][0];
                if(start>=end && min>=start )
                {
                        min = start;
                        arr[i] = j;   
                }
            }
        }
        return arr;
    }
}