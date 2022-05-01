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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        if(head.next == null) return head.val == val ? null : head;
        
        while(head != null && head.val == val) {
            head = head.next;
        }
        
        if(head == null) return null;
        
        ListNode curr = head;
        
        while(curr.next != null) {
            if(curr.next.next == null) {
                if(curr.next.val == val) {
                    curr.next = null;
                } 
                break;
            } else if(curr.next.val == val){
                curr.next = curr.next.next;
                continue;
            } 
            curr = curr.next;
        }
        
        return head;
    }
}