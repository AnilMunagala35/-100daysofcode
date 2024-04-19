
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        int count = 1;
        ListNode pseudoHead = new ListNode();
        pseudoHead.next = head;

        ListNode prev = pseudoHead;
        ListNode curr = head;
        ListNode next;
        
        ListNode joinFromLeft = null;
        ListNode joinToRight = null;

        // write logic in a single pass as per the follow up question
        while(curr != null && count <= right) {
            next = curr.next;
            if(count == left) {
                // record pointers where the reversed list should be attached.
                // left - 1 node would be pointing to the new Reversed head.
                // left node will be the new tail and would point to the 
                // remaining nodes
                joinFromLeft = prev;
                joinToRight = curr;
            }
            if(count >= left) {
                // reverse node logic
                curr.next = prev;
            }
            prev = curr;
            curr = next;
            count++;
        }
        joinFromLeft.next = prev;
        joinToRight.next = curr;
        return pseudoHead.next;
    }
}
