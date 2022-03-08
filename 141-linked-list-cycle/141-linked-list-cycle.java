/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        // map.add(temp);
        while(temp != null) {
            if(set.contains(temp)) return true;
            set.add(temp);
            temp = temp.next;
        }
        
        return false;
    }
}