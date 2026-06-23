class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list  = new ArrayList<>();
        int first =0;
        int second = 0;
        while(second<secondList.length && first<firstList.length)
        {
            int s1 = firstList[first][0];
            int e1 = firstList[first][1];
            int s2 = secondList[second][0];
            int e2 = secondList[second][1];
            if(s2<=e1 && e2>=s1)
            {
                list.add(new int[]{Math.max(s1,s2),Math.min(e1,e2)});
            }
            if(e1<e2)
            {
                first++;
            }
            else
            {
                second++;
            }
        }
        int[][] result = new int[list.size()][2];
        for(int k =0; k<list.size(); k++)
        {
            result[k] = list.get(k);
        }
        return result;

    }
}