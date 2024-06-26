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
        ListNode dummy = new ListNode(-1), dummy2 = dummy, temp = head;
        while(temp != null) {
            int a = 0;
            ListNode start = temp, end = temp;
            while(a < k && temp != null) {
                end = temp;
                temp = temp.next;
                a++;
            }
            if(a == k) {
                end.next = null;
                reverse(start);
                dummy2.next = end;
                dummy2 = start;
            } else {
                dummy2.next = start;
            }
        }
        return dummy.next;
    }

    private void reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
    }
}
