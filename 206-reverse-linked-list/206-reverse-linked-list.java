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
        if(head == null || head.next == null) return head;
        
//         ListNode prev = null, curr = head, next = head.next;
        
//         while(curr != null) {
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//             if(curr == null) break;
//             next = next.next;
//         }
//         head = prev;
//         return head;
        ListNode last = reverse(head, head.next);
        last.next = null;
        return this.head;
    }
    
    public ListNode reverse(ListNode node, ListNode next) {
        if(next == null) {
            this.head = node;
            return node;
        }
        
        ListNode temp = reverse(next, next.next);
        temp.next = node;
        return node;
    }
}