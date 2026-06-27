class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //  1   2   3   5
        //5 st
        //3
        //2
        //1
        //put first elemet in heap (arr[1]/arr[len-1])
        // removing that add the next two best possible ans in place of that to the min heap;
        //maintain a set so that no duplicate pair is present
        // [numerartor_idx, denominator_idx]
        PriorityQueue<int[]> heap = new PriorityQueue<>(
    (a, b) -> Double.compare(
        (double) arr[a[0]] / arr[a[1]],
        (double) arr[b[0]] / arr[b[1]]
    )
);
        Set <Pair<Integer,Integer>> set  = new HashSet<>();
        heap.add((new int[]{0,arr.length-1}));
        set.add(new Pair<>(0,arr.length-1));
        int [] ans  = new int [2];
        for(int i=0; i<k; i++)
        {
            int[] temp = heap.poll();
            int num_idx = temp[0];
            int den_idx = temp[1];
            ans  = new int[]{arr[num_idx],arr[den_idx]};
            if(num_idx+1<den_idx && !set.contains(new Pair<>(num_idx+1,den_idx)) && num_idx+1<arr.length)
            {
                heap.add(new int[]{num_idx+1,den_idx});
                set.add(new Pair<>(num_idx+1,den_idx));
            }
            if(num_idx<den_idx-1 && !set.contains(new Pair<>(num_idx,den_idx-1)) && den_idx-1>-1)
            {
                heap.add(new int[]{num_idx,den_idx-1});
                set.add(new Pair<>(num_idx,den_idx-1));
            }
        }
        return ans;
        

    }
}





























/*List<int[]> list = new ArrayList<>();
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
        return list.get(k-1); */