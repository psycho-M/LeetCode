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
    ListNode head = null;
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        
        ListNode prev = null, curr = head, next = head.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null) break;
            next = next.next;
        }
        head = prev;
        return head;
    }
    
//     public ListNode reverse(ListNode node) {
//         if(node.next == null) {
//             head = node;
//             return node;
//         }
        
//         ListNode temp = reverse(node.next);
        
//     }
}