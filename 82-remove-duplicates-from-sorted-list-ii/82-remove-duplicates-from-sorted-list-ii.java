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
        A LL question we have to delete all nodes that have duplicates.
        
        We use 2 pointers, a curr pointer and a prev pointer to keep track of the element before curr.
        We check 
        if curr.val is equal to curr.next.val,
            if yes,
                we check if curr is head, we then keep on moving the head pointer forward until the head 
                and its next element are diff, and then assign head to curr.
            else 
                we keep moving the curr pointer forward until the curr and its next elemetn are diff, and then we
                assign curr.next to prev.next. We don't change the prev to curr here as it isn't needed.
        else 
            we assign curr to prev and then move curr to next node.
        
    */
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = head, curr = head, currNext = head.next;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                if(curr == head) { //checking if head is duplicate
                    
                    while(head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                    
                    if(head.next == null) return null;
                    
                    head = head.next;
                    prev = curr = head;
                } else {
                    
                    while(curr.next != null && curr.val == curr.next.val) {
                        curr = curr.next;
                    }
                    
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}