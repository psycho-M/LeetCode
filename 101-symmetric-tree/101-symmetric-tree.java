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
class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root.left == null && root.right == null) return true;
        
//         Queue<TreeNode> leftQ = new LinkedList<>();
//         Queue<TreeNode> rightQ = new LinkedList<>();
        
//         leftQ.offer(root.left);
//         rightQ.offer(root.right);
        
//         while(!leftQ.isEmpty() && !rightQ.isEmpty()) {
//             int l = leftQ.size(), r = rightQ.size();
//             if(l != r) return false;
//             while(l-- > 0) {
//                 TreeNode curr = leftQ.poll();
//                 if(curr != null) {
//                     leftQ.offer(curr.left);
//                     leftQ.offer(curr.right);
//                 }
//             }
//             while(r-- > 0) {
//                 TreeNode curr = rightQ.poll();
//                 if(curr != null) {
//                     rightQ.offer(curr.right);
//                     rightQ.offer(curr.left);
//                 }
//             }
//             if(!areEqual(leftQ, rightQ)) return false;
//         }
        
//         return true;
//     }
    
//     boolean areEqual(Queue<TreeNode> q1, Queue<TreeNode> q2) {
//         if(q1.size() != q2.size()) return false;
        
        
//     }
    
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    
    boolean isMirror(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        return l.val == r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }
}