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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode fast=new ListNode(0);
        fast.next=head;
        ListNode curr=head,slow=fast;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode temp=reverse(slow.next);
        slow.next=null;
        ListNode next=null;
        while(curr!=null && temp!=null){
            next=temp.next;
            temp.next=curr.next;
            curr.next=temp;
            temp=next;
            curr=curr.next.next;
        }
        
    }
    
    private ListNode reverse(ListNode head){
       ListNode prev=null,next=null;
        
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
           
        
        return prev;
    }
}