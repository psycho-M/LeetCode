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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // int sum = 0;
        // return convert(root, 0);
        if(root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    
//     public TreeNode convert(TreeNode root, int sum) {
//         if(root == null) return root;
        
//         root.right = convert(root.right, sum);
//         root.left = convert(root.left, sum);
//         ro
//         if(root.right == null && root.left == null) {
//             sum += root.val;
//             root.val = sum;
//         }
        
//         return root;
        
//     }
}