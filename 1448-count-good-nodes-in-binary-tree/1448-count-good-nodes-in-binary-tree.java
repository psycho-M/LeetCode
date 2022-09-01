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
    public int goodNodes(TreeNode root) {
        int count = 0;
        return getGoodNodes(root, root.val);
    }
    
    private int getGoodNodes(TreeNode root, int prevHigh) {
        if(root == null) return 0;
        
        int toReturn = 0;
        
        if(prevHigh <= root.val) {
            prevHigh = root.val;
            toReturn = 1;
        }
        
        return toReturn + getGoodNodes(root.left, prevHigh) + getGoodNodes(root.right, prevHigh);
    }
}