class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i< arr.length; i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // val,freq
        PriorityQueue<int[]> heap  =new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            
            
            heap.offer(new int[]{entry.getKey(),entry.getValue()});
            
        }
            for(int i=0; i<k; i++)
            {
                int[] temp = heap.poll();
                int val = temp[0];
                int freq = temp[1];
                if(freq== 1)
                {
                    count++;
                    continue;
                }
                else
                {
                    freq--;
                    heap.offer(new int[]{val,freq});
                }
            }
            return map.size()-count;
        
    }
}