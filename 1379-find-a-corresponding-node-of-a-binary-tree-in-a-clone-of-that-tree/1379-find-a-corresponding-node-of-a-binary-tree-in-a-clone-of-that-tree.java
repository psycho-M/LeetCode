/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned.val == target.val) return cloned;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(cloned);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode temp = q.poll();
                if(temp.left != null) {
                    if(temp.left.val == target.val) return temp.left;
                    else q.offer(temp.left);
                }
                if(temp.right != null) {
                    if(temp.right.val == target.val) return temp.right;
                    else q.offer(temp.right);
                }
            }
        }
        
        return target;
    }
}