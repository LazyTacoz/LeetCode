class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap =  new PriorityQueue<>((a,b)->
        {
            if(a.length()!=b.length())
            {
                return a.length()-b.length();
            }
            else
            {
                return a.compareTo(b);
            }
        });
        // Integr.parseInt cant be used cox of time TLE
        //WE HAVE TO COMPARE LENGTH; IF SAME THEN USE COMPARETO FUNC
        for(int i = 0; i<nums.length; i++)
        {
            if(heap.size()<k)
            {
                heap.offer(nums[i]);
            }
            else if(heap.peek().length() == nums[i].length() && nums[i].compareTo(heap.peek())>=0)  
            {
                heap.poll();
                heap.offer(nums[i]);
            }
            else if (nums[i].length()>heap.peek().length())
            {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();

    }
}