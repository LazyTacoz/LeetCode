class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long MOD = 1000000007;
        long product = 1;
        for(int i=0; i<nums.length;i++)
        {
            heap.add(nums[i]);
        }
        for(int i=0; i<k;i++)
        {
            int temp = heap.poll();
            heap.add(temp+1);
        }
        if(heap.peek()==0)
        {
            return 0;
        }
        while(!heap.isEmpty())
        {
            product = (product * heap.poll()) % MOD;
        }
        return(int) product;
        
    }
}
/*
mod doesnt work on division
 int count = 0;
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i] == 0 )
            {
                heap.add(nums[i]);
                count++;
                continue;
            }
            heap.add(nums[i]);
            product*=nums[i];
        }
        if(count>k)
        {
            return 0;
        }
        for(int i=0; i<k; i++)
        {
            int temp = heap.poll();
            if(temp == 0)
            {
                heap.add(1);
                continue;
            }
            product = product * (temp+1);
            product = product/temp;
            heap.add(temp+1);
        }
        return (int)(product % MOD);
        */