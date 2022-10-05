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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode toAdd = new TreeNode(val);
            toAdd.left = root;
            root = toAdd;
        } else {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int currDepth = 1;
            while(!q.isEmpty()) {
                if(currDepth + 1 == depth) {
                    for(TreeNode t : q) {
                        TreeNode temp = null;
                        if(t.left != null) {
                            temp = t.left;
                        }
                        
                        t.left = new TreeNode(val);
                        t.left.left = temp;
                        temp = null;
                        if(t.right != null) {
                            temp = t.right;
                        }
                        
                        t.right = new TreeNode(val);
                        t.right.right = temp;
                    }
                    
                    break;
                } else {
                    int size = q.size();
                    // System.out.println(q);
                    while(size-- > 0) {
                        TreeNode temp = q.poll();
                        if(temp.left != null) q.offer(temp.left);
                        if(temp.right != null) q.offer(temp.right);
                    }
                    currDepth++;
                }
            }
        }
        
        return root;
    }
}