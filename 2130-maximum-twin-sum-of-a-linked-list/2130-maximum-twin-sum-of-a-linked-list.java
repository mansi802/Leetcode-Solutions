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
    public int maxPairList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode current = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        int max = Integer.MIN_VALUE;
        while (slow != null) {
            int sum = slow.val + current.val;
            if (max < sum) {
                max = sum;
            }
            slow = slow.next;
            current = current.next;
        }
        return max;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode next = head;
        ListNode current = head;

        while(current != null) {
            next = next.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
        public int pairSum(ListNode head) {
            return maxPairList(head);
        }
    }