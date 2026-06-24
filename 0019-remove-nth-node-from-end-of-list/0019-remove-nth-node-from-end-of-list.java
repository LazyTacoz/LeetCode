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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode  curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode ans = head;
        int i=0;
        while(curr!=null && i<n)
        {
            curr = curr.next;
            i++;
        }
        while(curr!=null)
        {
            prev = ans;
            ans = ans.next;
            curr = curr.next;
        }
        prev.next =ans.next;
        return dummy.next;
    }
}