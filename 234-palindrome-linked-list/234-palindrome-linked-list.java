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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        int n = 1;
        ListNode slow = head, fast = head;
        // Deque<ListNode> stack = new ArrayDeque<>();
        while(fast.next != null) {
            if(fast.next.next == null) {
                // stack.push(slow);
                n++;
                break;
            }
            // stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
            n += 2;
        }
        ListNode secondPart = slow.next;
        // System.out.println(secondPart.val);
        slow.next = null;
        
        ListNode prev = null, curr = secondPart, next = secondPart.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null) break;
            next = next.next;            
        }
        secondPart = prev;
        // System.out.println(secondPart.val);
        ListNode temp = secondPart;
        // while(temp != null) {
        //     System.out.print(temp.val + "->");
        //     temp = temp.next;
        // }
        // while(slow != null) {
        //     if(stack.pop().val != slow.val) return false;
        //     slow = slow.next;
        // }
        
        curr = head;
        for(int i = 0; i < n / 2; i++) {
            if(curr.val != secondPart.val) return false;
            curr = curr.next;
            secondPart = secondPart.next;
        }
        
        return true;
    }
}