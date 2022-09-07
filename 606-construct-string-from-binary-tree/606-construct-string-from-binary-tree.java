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
        if(root == null){
            return "";
        }
        if(root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        //left subtree
        String leftt = tree2str(root.left);
        //right subtree
        String rightt = tree2str(root.right);
        
        //if no right node exists
        if(rightt == "") {
            return String.valueOf(root.val) + "(" + leftt + ")";
        } else {
            return String.valueOf(root.val) + "(" + leftt + ")" + "(" + rightt + ")";
        }
    }
}