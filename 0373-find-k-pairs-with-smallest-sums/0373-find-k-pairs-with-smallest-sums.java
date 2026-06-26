class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //      i
        //      1    7   11
        // j 2  3    9   13   
        //   4  5    11  15
        //   6  7    13  17
        // first elemet is fixed(0,0) , the only next two possible are (1,0),(0,1), (0,1) better then , next availabke are (1,0),(1,1),(0,2)
        // store sum, i, j
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Pair<Integer,Integer>> set = new HashSet<>();
        int i=0;
        int j=0;
        heap.add(new int[]{nums1[i]+nums2[j],i,j});
        set.add(new Pair<>(i,j));
        List<List<Integer>> ans = new ArrayList<>();
        for(int x=0;x<k;x++)
        {
            int arr[] = heap.poll();
            int a = arr[1];
            int b = arr[2];
            set.add(new Pair<>(a,b));
            ans.add(Arrays.asList(nums1[arr[1]],nums2[arr[2]]));
            
            if(arr[1]<nums1.length-1 && !set.contains(new Pair<>(a+1,b)))
            {
            heap.add(new int[]{nums1[a+1]+nums2[b],a+1,b});
            set.add(new Pair<>(a+1,b));
            }
            if(arr[2]<nums2.length-1 && !set.contains(new Pair<>(a,b+1)))
            {
            heap.add(new int[]{nums1[a]+nums2[b+1],a,b+1}); 
            set.add(new Pair<>(a,b+1));  
            }
        }
        return ans;
    }
}
/*List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums1.length;i++)
        {
            for(int j=0; j<nums2.length;j++)
            {
                List <Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                ans.add(temp);
            }
        }
        Collections.sort(ans,(a,b)->(a.get(0)+a.get(1))-(b.get(0)+b.get(1)));
        List<List<Integer>> finalans = new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            finalans.add(ans.get(i));
        }
        return finalans;*/