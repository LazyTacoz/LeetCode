class Solution {
    int [] arr;
    public Solution(int[] w) {
        arr = new int [w.length];
        for(int i=0; i<w.length; i++)
        {
            if(i!=0)
            {
                arr[i] = w[i]+arr[i-1];
            }
            else
            {
                arr[i] = w[i];
            }
        }    
        
        }
    
    public int pickIndex() {
        /*
        Math.random() generates a decimal between 0.0 and 1.0.
        Examples: 0.0, 0.37, 0.99, 1.0 (exclusive)
        Math.random() * total scales it to 0.0 to total:
        Examples for total=4: 0.0, 1.48, 3.96
        (int)(Math.random() * total) cuts off decimal:
        Examples: 0, 1, 3
        + 1 shifts range from 0-3 to 1-4:
        */
        int total = arr[arr.length-1];
            // to generate random numbers
        int random = (int)(Math.random() * total) + 1;
        int low  = 0;
            int high = arr.length-1;
            while(low<high)
            {
                int mid = low+(high-low)/2;
                if(arr[mid]<random)
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


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */