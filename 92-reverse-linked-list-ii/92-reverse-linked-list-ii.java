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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        
        ListNode l = head, r = head, prev = null;
        int i = 1, j = 1;
        while(j < right) {
            if(i < left) {
                prev = l;
                l = l.next;    
            }
            r = r.next;
            i++;
            j++;
        }
        if(prev == null) head = r;
        reverse(l, r, prev, r.next);
        return head;
    }
    
    public void reverse(ListNode left, ListNode right, ListNode beforeLeft, ListNode afterRight) {
        ListNode prev = left, curr = left.next, next = curr.next;
        if(beforeLeft != null) beforeLeft.next = right;
        left.next = afterRight;
        
        while(prev != right) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next == null) break;
            next = next.next;
        }
    }
}