/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class myLL {
    myLL next;
    int val;
    
    public myLL(int val) {
        this.val = val;
        this.next = null;
    }
    
    public myLL(int val, myLL next) {
        this.val = val;
        this.next = next;
    }
    
    public String toString() {
        myLL temp = this;
        StringBuilder sb = new StringBuilder("[");
        while(temp != null) {
            sb.append(temp.val + ", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class BSTIterator {
    // myLL curr, list;
    LinkedList<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        inOrder(root, list);
        list.add(0, -1);
        // curr = list.getFirst();
    }
    
    private void inOrder(TreeNode root, LinkedList<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        // System.out.println(root.val);
        // myLL node = new myLL(root.val);
        // System.out.println(temp.val);
        // temp.next = node;
        // temp = temp.next;
        // System.out.println(temp.val);
        // System.out.println(list);
        inOrder(root.right, list);
    }
    
    public int next() {
        list.removeFirst();
        // System.out.println(curr.val);
        return list.getFirst();
    }
    
    public boolean hasNext() {
        return list.size() != 1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */