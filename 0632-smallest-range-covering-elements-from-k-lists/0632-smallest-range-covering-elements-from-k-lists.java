class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
     // TAKE ONE ELMENT FOM EACH LIST ,
     // PUT IN MINHEAP ALONG WITH THIER VALUE 
     //MAINTAIN MAX 
     //MIN_RANGE= MATH.MIN(MIN_RANGE,CURR RANGE)
     //RETURN MIN_RANGE ;
     //{ele_val,listno,idxno}
     PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
     int max = Integer.MIN_VALUE;
    for(int i=0;i<nums.size();i++)
    {
        heap.offer(new int[]{nums.get(i).get(0),i,0});
        max = Math.max(max,nums.get(i).get(0));
    }
    int[] res = {heap.peek()[0],max};
    while(true)
    {
        int [] temp = heap.poll();
        int list_no =temp[1];
        int idx = temp[2];
        if(nums.get(list_no).size()<=idx+1)
        {
            break;
        }
        max = Math.max(max,nums.get(list_no).get(idx+1));
        heap.offer(new int[]{nums.get(list_no).get(idx+1),list_no,idx+1});
        if(max-heap.peek()[0]<res[1]-res[0])
        {
            res[0] = heap.peek()[0];
            res[1] = max;
        }
        
    }
    return res;
    }
}