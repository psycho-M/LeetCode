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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode append = new ListNode(0), origHead = head, prev, temp;
        ListNode toAdd = append;
        while(head.val >= x) {
            temp = head;
            head = head.next;
            temp.next = null;
            append.next = temp;
            append = append.next;
            if(head == null) return origHead;
        }
        temp = head.next;
        prev = head;
        while(temp != null) {
            if(temp.val >= x) {
                prev.next = temp.next;
                append.next = temp;
                temp = temp.next;
                append = append.next;
                append.next = null;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        toAdd = toAdd.next;
        prev.next = toAdd;
        return head;
    }
}