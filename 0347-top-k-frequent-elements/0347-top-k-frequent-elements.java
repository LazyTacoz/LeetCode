class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(count<k)
            {
                heap.add(new int[]{entry.getKey(),entry.getValue()});
                count++;
            }
            else
            {
                if(entry.getValue()>heap.peek()[1])
                {
                    heap.poll();
                    heap.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int res[] = new int[k];
        int temp = 0;
        while(!heap.isEmpty())
        {
            res[temp] = heap.poll()[0];
            temp++;
        }
        return res;
    }
}