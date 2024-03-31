class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int c = 1;
        while (temp.next != null) {
            temp = temp.next;
            c++;
        }
        if (n == c) {
            return head.next;
        }
        ListNode t = head;
        int i = c - n;
        while (i > 1) {
            t = t.next;
            i--;
        }
        if (t.next != null) {
            t.next = t.next.next;
        }
        return head;
    }
}
