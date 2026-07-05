/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // f f f t t
     int low = 0;
        int high = n;
        while(low<high)
        {
            int mid = low +(high-low)/2;
            if(isBadVersion(mid) == false)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        return low;
    }
}
/*
  int low = 0;
        int high = n;
        while(low<high)
        {
            int mid = low +(high-low)/2;
            if(isBadVersion(mid) == false)
            {
                low = mid;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;

        */