class Solution {
    public int mySqrt(int x) {
        // 1 2 3 4 5 6 7 8 9 10
        // T T T F F F F F F F 
        //FIND LAST TRUE 
        //1 2 3 4 5 6 7 8 9 10
        //l       m          h 
        //l m   h            ans = 2  
        //    l h           ans = 3
        //      lh          
        //    h l
        if(x==1)
        {
            return 1;
        }
    int low = 1;
    int high = x;
    int ans = 0;
    //find first false
    //return false-1;
    while(low<high)
    {
        int mid = low+(high-low)/2;
        if((long)mid*mid>x)
        {
            high = mid;
        }
        else
        {
            low = mid+1;
        }
    }
        
        return low-1;
    }
}
/*
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
        */