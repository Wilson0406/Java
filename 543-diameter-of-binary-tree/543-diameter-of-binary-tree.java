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
    
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        int myHeight = Math.max(leftH,rightH) + 1;
        return myHeight;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int d1 = diameterOfBinaryTree(root.left);
        int d2 = diameterOfBinaryTree(root.right);
        int d3 = height(root.left) + height(root.right);
        return Math.max(Math.max(d1, d2), d3);
    }
}