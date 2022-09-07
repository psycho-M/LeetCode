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
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preOrder(root, res);
        return res.toString();
    }
    
    private void preOrder(TreeNode root, StringBuilder res) {
        if(root == null) return;
        
        res.append(root.val);
        
        if(root.left == null && root.right == null) 
            return;
        else if(root.left != null && root.right == null) {
            res.append("(");
            preOrder(root.left, res);
            res.append(")");
        } else {
            res.append("(");
            preOrder(root.left, res);
            res.append(")");    
            
            res.append("(");
            preOrder(root.right, res);
            res.append(")");
        }
        
    }
}