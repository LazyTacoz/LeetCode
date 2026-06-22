class Node
{
    char ch;
    int freq;
    int nextLegalTime;

    Node(char ch, int freq, int nextLegalTime)
    {
        this.ch = ch;
        this.freq = freq;
        this.nextLegalTime = nextLegalTime;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Node> queue = new ArrayDeque<>();
        Map<Character,Integer> map = new HashMap<>();
        List<Character> list  = new ArrayList<>();

        for(char ch : tasks)
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> heap =
                new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(char ch : map.keySet())
        {
            heap.add(new Node(ch, map.get(ch), 0));
        }
        while(!heap.isEmpty() || !queue.isEmpty())
        {
            while(heap.isEmpty()
            && !queue.isEmpty()
            && list.size() < queue.peek().nextLegalTime)
            {
                list.add(null);
            }
            while(!queue.isEmpty() && list.size() == queue.peek().nextLegalTime) 
            {
                heap.offer(queue.poll());
            }
            Node removed = heap.poll();
            list.add(removed.ch);
            removed.freq--;
            if(removed.freq>0)
            {
            queue.offer(new Node(removed.ch, removed.freq, list.size()+n));
            }
            
        }
        return list.size();
        
    }
}