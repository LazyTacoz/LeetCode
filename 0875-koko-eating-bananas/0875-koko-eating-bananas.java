class Solution {
    public boolean canFinish(int [] piles,int h,int n)
    {
        int count = 0;
        for(int i=0;i<piles.length;i++)
        {
            count+=Math.ceil((double)piles[i]/n);
        }
        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        // maximum k = max number in array
        // 3 6 7 11  sum = 27
        // 1,2,3,4,5,6,7,8,9,10,11
        // F F F T T T T T T  T  T    CONDITION -> no*h<sum
        int max = 0;
        for(int i=0; i<piles.length; i++)
        {
            max = Math.max(max,piles[i]);
        }
        int low = 1;
        int high = max;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(canFinish(piles,h,mid))
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