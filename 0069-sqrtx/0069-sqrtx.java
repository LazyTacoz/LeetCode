class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        // 1 2 3 4 5 6 7 8 9 10
        // T T T F F F F F F F 
        //FIND LAST TRUE 
    int ans = 0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if((long)mid*mid<=x)
            {   
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }

        }
        return ans ;
    }
}