class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<flowers.length;i++)
        {
            map.put(flowers[i][0],map.getOrDefault(flowers[i][0],0)+1);
            map.put(flowers[i][1]+1,map.getOrDefault(flowers[i][1]+1,0)-1);
        }
        int [][] flowersData = new int[map.size()][2];
        int bloom_no = 0;
        int i=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            bloom_no += entry.getValue();
            flowersData[i] = new int[]{entry.getKey(),bloom_no};
            i=i+1;
        }
        int [] res = new int[people.length];
        for(int j=0; j<res.length;j++)
        {
            int time  = people[j];
            if(time<flowersData[0][0])
            {
                res[j] = 0;
                continue;
            }
            if(time>=flowersData[flowersData.length-1][0])
            {
                res[j] = 0;
                continue;
            }
            int low = 0;
            int high = flowersData.length-1;
            while(low<high)
            {
                int mid = low+(high-low)/2;
                if(flowersData[mid][0]>time)
                {
                    high = mid;
                }
                else
                {
                    low = mid+1;
                }
            }

            res[j] = flowersData[low-1][1];
        }

        return res;
    }
}
/*for(int k=1; k<flowersData.length;k++)
            {
                if(time == flowersData[k][0])
                {
                    res[j] = flowersData[k][1];
                    break;
                }
                else if(time<flowersData[k][0])
                {
                    res[j] = flowersData[k-1][1];
                    break;
                }
*/