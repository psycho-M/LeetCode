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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> sort = new ArrayList<>(100);
        inOrder(root, sort);
        TreeNode res = new TreeNode(0), curr = res;
        for(int n : sort) {
            curr.right = new TreeNode(n);
            curr = curr.right;
        }
        
        return res.right;
    }
    
    void inOrder(TreeNode root, List<Integer> sort) {
        if(root == null) return;
        inOrder(root.left, sort);
        sort.add(root.val);
        inOrder(root.right, sort);
    }
}