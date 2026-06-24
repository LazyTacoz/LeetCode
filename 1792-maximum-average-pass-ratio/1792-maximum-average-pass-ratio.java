class Node
{
    double pass;
    double total;
    double diff;
    Node(double pass, double total,double diff)
    {
        this.pass = pass;
        this.total = total;
        this.diff = diff;
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Node> maxheap =
    new PriorityQueue<>((a,b) ->
        Double.compare(b.diff, a.diff));
        for(int i=0;i<classes.length;i++)
        {
            double pass_ = (double)(classes[i][0]);
            double total_ = (double)(classes[i][1]);
            maxheap.add(new Node(pass_,total_,((pass_+1)/(total_+1))-(pass_/total_)));
        }
        for(int i=0; i<extraStudents;i++)
        {
            Node minavg = maxheap.poll();
            Node to_add = new Node(minavg.pass+1,minavg.total+1,(((minavg.pass+2)/(minavg.total+2))-((minavg.pass+1)/(minavg.total+1))));
            maxheap.add(to_add);
        }
        double res=0;
        while(!maxheap.isEmpty())
        {
            Node temp = maxheap.poll();
            res+=temp.pass/temp.total;
        }
        return res/classes.length;
    }
}