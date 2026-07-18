class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(n==1 || n==0)
        {
            return 1;
        }
        if(map.containsKey(n))
        {
            return map.get(n);
        }
        int a = climbStairs(n-1);
        int b = climbStairs(n-2);
        map.put(n,a+b);
        return a+b;
    }
}