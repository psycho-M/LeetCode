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
    merging two sorted linked list(LL).
    we use two pointer method here, one on each LL.
    
    We compare the value of nodes at each pointer and add the the node with the smaller
    value to the mergeing LL.
    
    Once we reach the end of one of the LL, we add the rest of the nodes of other LL (if there
    are nodes that haven't been compared) and add them to the end of merged LL.
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode newList = new ListNode(), l1 = list1, l2 = list2;
        ListNode head = newList;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                newList.next = l1;
                l1 = l1.next;
            } else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }
        
        if(l1 != null) newList.next = l1;
        
        if(l2 != null) newList.next = l2;
        
        return head.next;
    }
}