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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head, fast = head;
        int n = 1;
        while(fast.next != null) {
            temp = temp.next;
            if(fast.next.next == null) {
                fast = fast.next;
                n += 1;
            } else {
                fast = fast.next.next;
                n += 2;
            }
        }
        
        k = k % n;
        
        if(k == 0) return head;
        
        int i = 1;
        temp = head;
        while(i < n - k) {
            i++;
            temp = temp.next;
        }
        
        // System.out.println(temp.val);
        
        ListNode newHead = temp.next;
        temp.next = null;
        fast.next = head;
        head = newHead;
        
        return head;
    }
}