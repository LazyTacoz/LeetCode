class Solution {
    public boolean possible(int capacity,int[] weights, int days)
    {
        int sum = 0;
        int count = 1;
        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            if(sum>capacity)
            {
                sum = weights[i];
                count++;
            }
            
        }
        return count<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int low = 0;
        for(int i=0; i<weights.length; i++)
        {
            sum+=weights[i];
            low = Math.max(low,weights[i]);
        }
        int high = sum;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(possible(mid, weights,days))
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
}