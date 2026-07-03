class Node 
{
    int freq;
    char ch;
    Node(char ch,int freq)
    {
        this.freq = freq;
        this.ch = ch;
    }
}
class Solution {
    public String reorganizeString(String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b)->b.freq-a.freq);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer>entry : map.entrySet())
        {
                heap.offer(new Node(entry.getKey(),entry.getValue()));
        }   
        Node prev = null;
        while(!heap.isEmpty())
        {
            Node curr = heap.poll();
            sb.append(curr.ch);
            curr.freq--;
            if(prev!=null && prev.freq>0)
            {
                heap.offer(prev);
            }
            prev = curr;
        }

        if (sb.length() != s.length()) {
            return "";
        }

        return sb.toString();
    }
}
// make hashmap
        //store freq
        // make maxheap -> according to freq
        // make string builder,
        // poll one , add to stringbuilder, store it somewhere 
        //if next letter present, then add to styringbuilder and back to heap with freq-- 
        //if next letter not present then return "";
        //add first letter with freq--;