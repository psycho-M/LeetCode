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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode one = head, two = head.next, prev;
        // first head swap
        one.next = two.next;
        two.next = one;
        head = two;
        
        if(one.next == null) return head;
        
        prev = one;
        one = one.next;
        two = one.next;
        while(two != null) {
            prev.next = two;
            one.next = two.next;
            two.next = one;
            if(one.next == null) break;
            prev = one;
            one = one.next;
            two = one.next;
        }
        
        return head;
    }
}