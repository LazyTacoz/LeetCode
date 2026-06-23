class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<trips.length;i++)
        {
            map.put(trips[i][1],map.getOrDefault(trips[i][1],0)+trips[i][0]);
            map.put(trips[i][2],map.getOrDefault(trips[i][2],0)-trips[i][0]);
        }
        int temp = 0;
        for(Map.Entry<Integer,Integer>entry : map.entrySet())
        {
            temp+=entry.getValue();
            if(temp>capacity)
            {
                return false;
            }
        }
        return true;
    }
}