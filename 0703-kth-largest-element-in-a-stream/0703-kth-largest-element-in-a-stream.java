class KthLargest {
    List<Integer> list  = new ArrayList<>();
    int kth;
    public KthLargest(int k, int[] nums) {
        list  = new ArrayList<Integer>();
        kth = k;
        for(int i=0; i<nums.length; i++)
        {
            list.add(nums[i]);
        }
    }
    
    public int add(int val) {

        list.add(val);
        Collections.sort(list);
        if(list.size()>kth-1) 
        {
            return list.get(list.size()-kth);
        }
        return 0;
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */