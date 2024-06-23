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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=null;
        for(int i=0;i<lists.length;i++){
            head=merge(head,lists[i]);
        }
        return head;
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode head= new ListNode();
        ListNode node = head;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                node.next=temp1;
                temp1=temp1.next;
                node=node.next;
            }
            else{
                node.next=temp2;
                temp2=temp2.next;
                node=node.next;
            }
        }
        node.next=(temp1!=null)? temp1:temp2;
        return head.next;
    }
}
