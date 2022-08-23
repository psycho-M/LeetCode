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
        int n = 1;
        ListNode slow = head, fast = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while(fast.next != null) {
            if(fast.next.next == null) {
                stack.push(slow);
                n++;
                break;
            }
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
            n += 2;
        }
        // System.out.println(slow.val);
        slow = slow.next;
        // System.out.println(stack);
        // if((n & 1) == 1) stack.pop();
        
        while(slow != null) {
            if(stack.pop().val != slow.val) return false;
            slow = slow.next;
        }
        
        return true;
    }
}