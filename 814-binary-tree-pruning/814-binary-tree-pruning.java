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
    public TreeNode pruneTree(TreeNode root) {
        if(toPrune(root)) return null;
        return root;
    }
    
    private boolean toPrune(TreeNode root) {
        if(root.left == null && root.right == null) {
            if(root.val == 0) return true;
            else return false;
        }
        
        if(root.left != null && toPrune(root.left)) root.left = null;
        if(root.right != null && toPrune(root.right)) root.right = null;
        
        if(root.left == null && root.right == null) {
            if(root.val == 0) return true;
            else return false;
        }
        
        return false;
    }
}