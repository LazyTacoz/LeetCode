class Solution {
    public int helper(int n, int[] arr)
    {
        if(arr[n]!=0)
        {
            return arr[n];
        }
        if(n == 0 || n == 1)
        {
            return n;
        }
        int a = helper(n-1,arr);
        int b = helper(n-2,arr);
        arr[n] = a+b;
        return a+b;
    }
    public int fib(int n) {
        int[] arr  = new int[n+1];
        return helper(n,arr);
    }
}