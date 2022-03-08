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
    /*
        Two approaches
        
        One:Using a HashSet to store all the visited nodes.
            We go through the LL and check if the current node is present in the hash set.
            if yes 
                we return true, as a cycle is present
            else
                add the current node to the set.
            
            If we get out of the loop, that means no cycle is present, we return true;
            
            Space Complexity: O(n)
            
        Two:We use two pointers, a slow pointer and a fast one. (the same used in find the length of the LL).
            We go one step at a time for the slow pointer, and two steps at a time for fast pointer.
            If the fast pointer reaches the end, and there is no cycle, we exit the loop and return false.
            
            Now, if there is a cycle, there will be a time where both fast and slow pointers point towards
            the same node, when this happens, we can return true.
            It is a guarantee that there will come a node when both the pointers point towards this same node
            as the fast one might skip elements, but the slow will always traverse through all the nodes in the
            cycle.
            
            Space Complexity: O(1)
    */
    
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        // HashSet approach
        // HashSet<ListNode> set = new HashSet<>();
        // ListNode temp = head;
//         while(temp != null) {
//             if(set.contains(temp)) return true;
//             set.add(temp);
//             temp = temp.next;
//         }
        
//         return false;
        
        // Two pointer Approach
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        
        return false;
    }
}