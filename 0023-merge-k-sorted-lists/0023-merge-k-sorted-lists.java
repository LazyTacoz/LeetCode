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
}