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
    public int count(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        
        return count;
    }
    
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first=head,second=head;
        int end=count(head)-k+1;
        
        for(int i=0;i<k-1;i++)
            first=first.next;
        
        ListNode p=first;
        
        for(int i=0;i<end-1;i++)
            second=second.next;
        
        ListNode q=second;
        
        int data=p.val;
        p.val=q.val;
        q.val=data;
        
        return head;
        
    }
}