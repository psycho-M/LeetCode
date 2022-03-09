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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = head, curr = head, currNext = head.next;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                if(curr == head) {
                    while(head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                    if(head.next == null) return null;
                    head = head.next;
                    prev = curr = head;
                } else {
                    while(curr.next != null && curr.val == curr.next.val) {
                        curr = curr.next;
                    }
                    
                    // if(curr.next == null) return head;
                    
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}