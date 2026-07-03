class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->
        {
            if(a[0]==b[0])
            {
                return a[1]-b[1];
            }
            else
            {
                return a[0]-b[0];
            }
        });
        for(int i=0; i<nums.length; i++)
        {
            heap.add(new int[]{nums[i],i});
        }
        for(int i=0;i<k; i++)
        {
            // remove min, 
            //add multiplied by multiplier
            int[] temp = heap.poll();
            heap.add(new int[]{temp[0]*multiplier,temp[1]});
        }
        int j=0;
        while(!heap.isEmpty())
        {
            int temp[]  = heap.poll();
            nums[temp[1]] = temp[0];
        }
        return nums;
    }
}