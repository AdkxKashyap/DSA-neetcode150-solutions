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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            };
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            };

            ListNode nn = new ListNode(carry % 10);
            tmp.next = nn;
            tmp = tmp.next;
            carry = carry / 10;
        }
        tmp.next = carry == 0 ? null : new ListNode(carry);

        return dummy.next;
    }
}
