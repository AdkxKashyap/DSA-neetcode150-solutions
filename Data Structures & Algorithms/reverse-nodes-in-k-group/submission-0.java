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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        ListNode start = head;
        ListNode end = head;
        ListNode nxt = head;

        int len = getLength(head);

        while(len >= k) {
            for(int i = 0; i < k - 1; i++) {
                end = end.next;
            }

            nxt = end.next;
            end.next = null;

            reverse(start);
            tmp.next = end;
            tmp = start;

            start = nxt;
            end = nxt;
            len = len - k;
        }
        tmp.next = nxt;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
    } 
}
