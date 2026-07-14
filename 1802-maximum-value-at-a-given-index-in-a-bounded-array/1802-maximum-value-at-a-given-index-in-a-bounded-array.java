class Solution {
    public boolean Possible(int maxSum,int index,int length, int val)
    {
        long sum_l = 0;
        long sum_r = 0;
        // left part
        if(val<=index) //  multiple 1s exist
        {
            sum_l = ((long)val*(val+1))/2 + index-val+1;
        }
        else // no multiple 1s exist
        {
            sum_l = ((long)(index+1)*(2*val-index))/2;
        }
        if(val <= length - index-1) // multiple 1 exist on right side
        {
            sum_r = ((long)val*(val+1))/2 + length-index-val;
        }
        else  //  no multiple 1 exist on right side
        {
            long n = length-index;
            int d =1;
            long a = val-(length-index)+1;
            sum_r = ((n)*(2*a+(n-1)*d))/2;
        }
        return sum_r+sum_l-val<=maxSum;
    }
    public int maxValue(int n, int index, int maxSum) {
        //nums.length == n
        //nums[index] is maximized
        //n/2(2a+(n-1)d)
        //T T T T T F F F F F F F F F F F F
        int low = 1;
        int high = maxSum;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(!Possible(maxSum,index,n, mid))
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        // edge case if all true 
        return Possible(maxSum,index,n, low) ? low : low-1;
    }
}