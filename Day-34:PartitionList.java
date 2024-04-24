class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode tem = head;
        ListNode node = new ListNode(-1);
        ListNode tem2 = node;
        while(tem!=null){
            if(tem.val<x){
                ListNode n = new ListNode(tem.val);
                node.next = n;
                node = n;
            }
            tem = tem.next;
        }
        tem = head;
        while(tem!=null){
            if(tem.val>=x){
                ListNode n = new ListNode(tem.val);
                node.next = n;
                node = n;
            }
            tem = tem.next;
        }
        return tem2.next;
    }
}
