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
    public void flatten(TreeNode root) {
        TreeNode temp = root;
        preOrder(temp);
    }
    
    TreeNode preOrder(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        if(left != null) {
            root.right = left;
            left = preOrder(left);
            if(right != null) {
                left.right = right;
                return preOrder(right);
            } else return left;
        }
        
        return preOrder(right);
    }
}