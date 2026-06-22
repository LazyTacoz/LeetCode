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
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        //calculate size of the LL.
        ListNode curr = head;
        int length = 0;
        while(curr!=null)
        {
            length++;
            curr = curr.next;
        }
        // DUMMY NOT NEEDED AS NO HEAD CHANGE
        //CREATE A REVERSE FUNCTION
        //GO TILL END OF THE LIST . CREATE REFRENCE OF NEXT NODE THEN CUT THE LIST REEVRSE THE LIST AND RELINK
        curr = head.next;
        length--;
        ListNode prev = head;
        if(head == null)
        {
            return null;
        }
        // remaining node 
        //if i< emaining node one condition 
        //i> emaining nodes then according to no of remainign nodes
        // can declare a varibale called actual size to check between the actual size if remaing node or i
        int j =2; 
        while(curr!=null)
        {
            ListNode currGrouphead = curr;
            ListNode currGrouptail = curr;
            ListNode nextGroupHead = null;
            int actual_size = Math.min(length,j);
            if(actual_size % 2 == 0)
            {
                for(int i=0; i<actual_size-1; i++)
                {
                    currGrouptail = currGrouptail.next;
                }
                nextGroupHead = currGrouptail.next;
                currGrouptail.next = null;
                ListNode reversedHead = reverse(currGrouphead);
                prev.next = reversedHead;
                currGrouphead.next = nextGroupHead;
                prev = currGrouphead;
            }
            else
            {
                for(int i=0; i<actual_size-1; i++)
                {
                    currGrouptail = currGrouptail.next;
                }
                nextGroupHead = currGrouptail.next; 
                prev = currGrouptail;
            }
            
            curr = nextGroupHead;
            length = length-j;
            j++;
        }
        return head;
    }
}