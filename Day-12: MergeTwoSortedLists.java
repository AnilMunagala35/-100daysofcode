class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode f=list1;
        ListNode s=list2;
        ListNode head = new ListNode();
        ListNode node = head;
        while(f!=null && s!=null){
            if(f.val<s.val){
                node.next=f;
                f=f.next;
                node=node.next;
            }
            else{
                node.next =s;
                s=s.next;
                node=node.next;
            }
        }
        node.next = (f!=null)? f:s;
        return head.next;
    }
}
