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
    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        int len = arr.size();
        int l = arr.get(k - 1);
        int r = arr.get(len - k);
        arr.set(k - 1, r);
        arr.set(len - k, l);
        temp = head;
        for(int n : arr) {
            temp.val = n;
            temp = temp.next;
        }
        return head;
    }
}