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

    /*
        We use two pointers to solve this problem.
        We add the vals of the current nodes and the carry from the last node calc, store it 
        into curr.
        Then we divide the curr by 10 and store it into carry. This tells us if there's a 
        carry forward number present or not.
        We calculate the modulo of curr with 10 and add it into the next node of the 
        resultant LL.
        We iterate until we cover all the nodes.
        When all nodes have been visited, we check 
        if carry > 0
            we add a new node at the end of the resultant LL and return the LL.
        else just  return the resultant LL.
    */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode head, ans;
//         ans = head = null;
//         // ans = l1;
//         int carry = 0;
//         while(l1 != null && l2 != null) {
            
//             int curr = l1.val + l2.val + carry;
//             ListNode temp = new ListNode(curr % 10);
            
//             if(head == null) {
//                 head = ans = temp;
//                 l1 = l1.next;
//                 l2 = l2.next;
//                 carry = curr / 10;
//                 continue;
//             }
            
//             ans.next = temp;
//             ans = ans.next;
//             // ans.val = curr % 10;
            
//             // sum = (sum * 10) + curr % 10;
//             carry = curr / 10;
            
//             l1 = l1.next;
//             l2 = l2.next;
//         }
        
//         while(l1 != null) {
//            ListNode temp = new ListNode();
//            temp.val = (carry + l1.val) % 10;
//            ans.next = temp;
//            ans = ans.next;
//            carry = (carry + l1.val) / 10;
//            l1 = l1.next;
//         }
        
//         while(l2 != null) {
//            ListNode temp = new ListNode();
//            temp.val = (carry + l2.val) % 10;
//            ans.next = temp;
//            ans = ans.next;
//            carry = (carry + l2.val) / 10;
//            l2 = l2.next;
//         }
        
//         if(carry != 0)
//             ans.next = new ListNode(carry);
      
//         return head;
        
        ListNode res = new ListNode(0);
        
//         ListNode temp = res;
//         int carry = 0, a, b, sum;
//         while(l1 != null || l2 != null) {
//             a = l1 == null ? 0 : l1.val;
//             b = l2 == null ? 0 : l2.val;
//             sum = a + b + carry;
//             carry = sum / 10;
//             temp.next = new ListNode(sum % 10);
//             temp = temp.next;
//             if(l1 != null) l1 = l1.next;
//             if(l2 != null) l2 = l2.next;
//         }
        
//         if(carry > 0) temp.next = new ListNode(carry);
        
        return add(l1, l2, 0);
        
    }
    
    //recursive soln.
    ListNode add(ListNode l1, ListNode l2, int carry) {
        if(l1 == null & l2 == null && carry == 0) {
            return null;
        }
        
        carry += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        ListNode curr = new ListNode(carry % 10);
        curr.next = add(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, carry / 10);
        return curr;
    }
}