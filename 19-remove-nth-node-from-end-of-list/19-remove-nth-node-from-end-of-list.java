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
    
    /*
        We use two pointer approach in this one.
        We traverse the list till the nth node, and put one pointer (left) there, the other one
        (right) at the head of the LL.
        Then we move both nodes to the right together until the right node reaches the end 
        of LL.
        Remove the node next to the left node as it will be the nth node from the end.
    */
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        
        // if()
        
        ListNode l, r;
        l = r = head;
        
        while(n > 0) {
            r = r.next;
            n--;
        }
        
        if(r == null) {
            head = head.next;
            return head;
        }
        
        // System.out.println(r.val);
        while(r.next != null) {
            r = r.next;
            l = l.next;
        }
        // System.out.println(l.val);
        
        l.next = l.next.next;
        
        return head;
    }
}