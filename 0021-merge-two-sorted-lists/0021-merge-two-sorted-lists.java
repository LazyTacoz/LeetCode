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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode left = list1;
        ListNode right = list2;
        ListNode curr = dummy;
        while(left!=null && right!=null)
        {
            if(left.val<=right.val)
            {
                curr.next = left;
                curr = left;
                left = left.next;
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
            left = left.next;
        }
        while(right!=null)
        {
            curr.next = right;
            curr = right;
            right = right.next;
        }
        return dummy.next;

    }
}