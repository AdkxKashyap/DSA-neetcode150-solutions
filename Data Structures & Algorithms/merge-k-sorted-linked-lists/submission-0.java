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

/*Using Merge Sort*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        int n = lists.length;
        if(n == 0) return null;
        return helper(0, n-1, lists);
    }

    private ListNode helper(int left, int right, ListNode[] lists) {
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode leftList = helper(left, mid, lists);
        ListNode rightList = helper(mid + 1, right, lists);
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            }else {
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        tmp.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
