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
    public void helper(ListNode prev, ListNode curr)
    {
        if(curr == null || curr.next == null )
        {
            return;
        }
        ListNode first = curr;
        ListNode next = first.next;
        first.next = next.next;
        next.next  = first;
        prev.next = next;
        helper(curr,curr.next);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy  = new ListNode(-1);
        ListNode prev = dummy;  
        dummy.next = head;
        helper(prev,head);
        return dummy.next;
    }
}