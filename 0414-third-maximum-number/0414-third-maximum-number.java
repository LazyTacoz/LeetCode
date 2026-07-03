class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length;i++)
        {
            if(heap.size()<3 && !set.contains(nums[i]))
            {
                heap.offer(nums[i]);
                set.add(nums[i]);
            }
            else if(heap.peek()<nums[i] && !set.contains(nums[i]))
            {
                heap.offer(nums[i]);
                heap.poll();
                set.add(nums[i]);
            }
        }
        if(set.size()<3)
        {
            return Collections.max(set);
        }
        return heap.peek();
    }
}