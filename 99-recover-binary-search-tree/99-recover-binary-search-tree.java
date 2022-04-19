// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
class Solution {
//     public void recoverTree(TreeNode root) {
//         TreeNode prev = null, first = null, second = null;
//         inOrder(root, prev, first, second);
//         // System.out.println(prev + " " + first + " " + second);
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     }
    
//     public void inOrder(TreeNode root, TreeNode prev, TreeNode first, TreeNode second) {
//         if(root == null) return;
//         inOrder(root.left, prev, first, second);
        
//         if(prev != null && prev.val >= root.val) {
//             if(first == null) first = prev;
//             second = root;
//             System.out.println(prev.val + " " + first.val + " " + second.val);
//         }
//         prev = root;
        
//         inOrder(root.right, prev, first, second);
//     }
// }

public void recoverTree(TreeNode root) {
        //use inorder traversal to detect incorrect node
        TreeNode[] preFirSec = new TreeNode[3];
        inOrder(root, preFirSec);
        int temp = preFirSec[1].val;
        preFirSec[1].val = preFirSec[2].val;
        preFirSec[2].val = temp;
    }

    public void inOrder(TreeNode root, TreeNode[] preFirSec){
        if(root == null) {
            return;
        }
        
        inOrder(root.left, preFirSec);//search left tree

        //in inorder traversal of BST, prev should always have smaller value than current value
        if(preFirSec[0] != null && preFirSec[0].val >= root.val){
            //incorrect smaller node is always found as prev node
            if(preFirSec[1] == null) {
                preFirSec[1] = preFirSec[0];
            }
          //incorrect larger node is always found as curr(root) node
            preFirSec[2] = root;
        }
        
        preFirSec[0] = root;//update prev node        
        inOrder(root.right, preFirSec);//search right tree
    }
}