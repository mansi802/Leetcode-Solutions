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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode t1=list1;
        ListNode t2=list1;
        ListNode tmp=list2;
        
        while(tmp.next!=null) tmp=tmp.next;
        
        while(a-->1){
            t1=t1.next;
        }
        
        while(b-->-1){
            t2=t2.next;
        }
        
        t1.next=list2;
        tmp.next=t2;
        
        return list1;
    }
}