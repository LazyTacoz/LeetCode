class Solution {
    public boolean isPossible(int[] target) {
        //reverse engineering ..from the target array , come up with the array that lead to it , and only possible if the max no is choosen 
        //if at any point val<1 then false
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        if(target[0]!=1 && target.length==1)
        {
            return false;
        }


        for(int i=0; i<target.length; i++)
        {
            maxheap.add(target[i]);
            sum+=target[i];
        }
        while(true)
        {
            int max = maxheap.poll();
            if(max==1)
            {
                break;
            }
            long rest = sum-max;
            int no_tobe_added = (int)(max % rest);
            if(rest == 1)
            {
                return true;
            }
            if(no_tobe_added <=0 || no_tobe_added == max)
            {
                return false;
            }
            maxheap.add(no_tobe_added);
            sum = rest+no_tobe_added;
        }
        return true;
    }
}