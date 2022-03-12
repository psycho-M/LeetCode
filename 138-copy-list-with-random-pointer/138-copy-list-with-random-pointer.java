/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // if(head.next == null) return new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(0), newHead = res;
        Node temp = head;
        
        while(temp != null) {
            res.next = new Node(temp.val);
            map.put(temp, res.next);
            res = res.next;
            temp = temp.next;
        }
        
        temp = head;
        res = newHead.next;
        while(temp != null) {
            res.random = map.get(temp.random);
            temp = temp.next;
            res = res.next;
        }
        
        return newHead.next;
    }
}