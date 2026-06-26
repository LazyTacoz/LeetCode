/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode merge(ListNode a, ListNode b)
    {
        ListNode dummy  = new ListNode(0);
        ListNode curr = dummy;
        ListNode left = a;
        ListNode right = b; 
        while(left!=null && right!=null)
        {
            if(left.val<=right.val)
            {
                curr.next = left;
                curr = left;
                left= left.next;
            }
            else
            {
                curr.next = right;
                curr = right;
                right = right.next;
            }
        }
        while(left!=null)
            {
                curr.next = left;
                curr = left;
                left= left.next;
            }
            while(right!=null)
            {
                curr.next = right;
                curr = right;
                right = right.next;
            }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            return null;
        }
        while(lists.length>1)
        {
            int count  = lists.length%2 == 0 ? lists.length/2 : (lists.length+1)/2;
            ListNode [] res = new ListNode[count];
            for(int i=0,j=0; i<lists.length;i+=2,j++)
            {   
                if(i<lists.length-1)
                {
                    res[j] = merge(lists[i],lists[i+1]);
                }
                else
                {
                    res[j] = lists[i];
                }
            }
            lists = res;
        }
        
        return lists[0];
    }
}
/*class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //create minheap according to value 
        //create a dummy node as unsure of the head 
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i=0; i<lists.length; i++)
        {
            if(lists[i] != null)
            {
                heap.add(lists[i]);
            }

        }
        while(!heap.isEmpty())
        {
            ListNode temp = heap.poll();
            ListNode next = null;
            if(temp.next!=null)
            {
                next = temp.next;
                heap.add(next);

            }
            curr.next = temp;
            temp.next = null;
            curr = temp;
        }
        return dummy.next;
    }
}*/
