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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList=new ListNode();
        ListNode dummy=newList;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            
            int data=(sum+carry)%10;
            carry=(sum+carry)/10;
            dummy.next=new ListNode(data);
            dummy=dummy.next;
        }
        
        if(carry!=0)
            dummy.next=new ListNode(carry);
        
        return newList.next;
    }
}