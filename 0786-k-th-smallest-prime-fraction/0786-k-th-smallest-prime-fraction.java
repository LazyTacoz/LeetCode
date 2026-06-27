class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<arr.length;i++)
        {
            int a = arr[i];
            for(int j = i+1; j<arr.length; j++)
            {
                int b = arr[j];
                list.add(new int[]{a,b});
            }
        }
        Collections.sort(list, (x, y) ->
    Double.compare((double)x[0] / x[1], (double)y[0] / y[1]));
        return list.get(k-1);
    }
}