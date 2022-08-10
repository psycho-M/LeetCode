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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        root = toBST(root, 0, nums.length - 1, nums);
        return root;
    }
    
    private TreeNode toBST(TreeNode root, int start, int end, int[] nums) {
        int mid = (start + end) / 2;
        // System.out.println(start + " " + mid + " " + end);
        root = new TreeNode(nums[mid], null, null);
        if(mid - 1 >= start) root.left = toBST(root.left, start, mid - 1, nums);
        if(mid + 1 <= end) root.right = toBST(root.right, mid + 1, end, nums);;
        return root;
    }
}