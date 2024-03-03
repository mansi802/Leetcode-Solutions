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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start=new ListNode();
        start.next=head;
        ListNode fast=start,slow=start;
        
        while(n-->0) fast=fast.next;
        
        if(fast==null) return null;
        
        if(fast.next==null){
            head=head.next;
            return head;
        }
        
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        if(slow!=null && slow.next!=null) slow.next=slow.next.next;
        return head;
    }
}