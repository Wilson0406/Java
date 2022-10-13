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
    public TreeNode inorderSuccessor(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
        
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1 -> No child, Delete Node, return null to parent
            if(root.left == null && root.right == null) {
                return null;
            } 
            // Case 2 -> 1 child, Delete Node and replace with child node
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            // Case 3 -> 2 child, Replace value with inorder successor(leftmost node in right subtree), Delete the node for inorder successor
            TreeNode InorderSuccessor = inorderSuccessor(root.right);
            root.val = InorderSuccessor.val;
            root.right = deleteNode(root.right, InorderSuccessor.val);
        }
        return root;
    }
}