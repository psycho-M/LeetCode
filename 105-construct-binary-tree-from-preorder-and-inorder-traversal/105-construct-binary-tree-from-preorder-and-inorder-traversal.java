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
    int preI;
    public TreeNode buildTree(int[] pre, int[] in) {
        preI = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) map.put(in[i], i);
        return buildTree(pre, 0, pre.length - 1, map);
    }
    
    public TreeNode buildTree(int[] pre, int l, int r, Map<Integer, Integer> map) {
        if(l > r) return null;
        
        int rootVal = pre[preI++];
        TreeNode root = new TreeNode(rootVal);
        int mapI = map.get(rootVal);
        root.left = buildTree(pre, l, mapI - 1, map);
        root.right = buildTree(pre, mapI + 1, r, map);
        
        return root;
    }
}