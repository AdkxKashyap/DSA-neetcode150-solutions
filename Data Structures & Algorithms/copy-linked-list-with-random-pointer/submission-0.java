/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cHead = getClone(head);
        zigzag(head, cHead);
        buildRandomPointers(head);
        buildOriginal(head);
        return cHead;
    }

    private Node getClone(Node head) {
        Node dummy = new Node(-1);
        Node curr = head;
        Node copy = dummy;
        while(curr != null) {
            Node tmp = new Node(curr.val);
            copy.next = tmp;
            copy = copy.next;
            curr = curr.next; 
        }
        return dummy.next;
    }

    private void zigzag(Node head1, Node head2) {
        while(head2 != null) {
            Node next1 = head1.next;
            Node next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
    }

    private void buildRandomPointers(Node head) {
        while(head != null) {
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next.next;
        }
    }

    private void buildOriginal(Node head) {
        Node tmp = head;
        while(tmp != null && tmp.next != null) {
            Node next = tmp.next;
            tmp.next = tmp.next.next;
            tmp = next;
        }
    }
}
