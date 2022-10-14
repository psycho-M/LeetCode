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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        // if(head.next.next == null) 
        int count = 1;
        ListNode temp = head, fast = head;
        while(fast.next != null) {
            if(fast.next.next == null) {
                count++;
                break;
            }
            count += 2;
            fast = fast.next.next;
        }
        
        count = count / 2;
        // temp = head;
        while(count-- > 1) {
            temp = temp.next;
        }
        
        // System.out.println(temp.val + temp.next.next.val);
        // fast = temp.next;
        // temp.next = fast.next;
        // fast.next = null;
        temp.next = temp.next.next;
        
        return head;
        
        
    }
}