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
    I've solved this one two approaches - 1) merging lists one by one
                                          2) merging lists using bottom up merge sort.
    
    We have a common method for merging two LL.
    
    For the first method, we create a res node. We traverse the array of lists and keep
    merging every index of the array with the res LL.
    Time complexity O(k * n), k = length of the array.
    
    For the second method we use the bottom up merge sort technique.
    We start with the width of each individual sub-problem as 1.
    Merge first two lists, the next two list, etc. until the end of lists array.
    Then we double the width lenght to 2, and merge first 4 lists, but in the linked list
    case, we merge first and third lists, fifth and seventh lists, etc.
    As we double the list width, we traverse till 
        (length of array lists - current width of subproblem) size to skip
    the repetition of already merged lists.
    
    This method/algo results in a time complexity of O(n * log(k))
    
    
    
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        
        ListNode res = lists[0];
        
        //merging one list with next, then mergeing the merged list with the next one and so on..
        // for(int i = 1; i < lists.length; i++) {
        //     res = mergeTwoLists(res, lists[i]);
        // }
        
        //bottom up merge sort
        for(int width = 1; width < lists.length; width *= 2) {
            for(int i = 0; i < lists.length - width; i += width * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + width]);
                
            }
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        
        if(l1 == null) res.next = l2;
        if(l2 == null) res.next = l1;
        
        return head.next;
    }
}