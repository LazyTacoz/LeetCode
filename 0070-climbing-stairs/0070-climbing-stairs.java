class Solution {
    int[] arr = new int[46];
    public int climbStairs(int n) {
        if(n==1 || n==0)
        {
            return 1;
        }
        if(arr[n]!=0)
        {
            return arr[n];
        }
        int a = climbStairs(n-1);
        int b = climbStairs(n-2);
        arr[n] = a+b;
        return a+b;
    }
}