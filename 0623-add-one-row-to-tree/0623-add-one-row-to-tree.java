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
    public void insert(TreeNode root, int val, int depth, int currDepth) {
        if(root == null) return;
        if(currDepth == depth - 1) {
            // for left child node
            TreeNode temp = root.left;
            root.left = new TreeNode(val);
            root.left.left = temp;
            // for right child node
            temp = root.right;
            root.right = new TreeNode(val);
            root.right.right = temp;
            
        } else {
            insert(root.left, val, depth, currDepth + 1);
            insert(root.right, val, depth, currDepth + 1);
        }
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insert(root, val, depth, 1);
        return root;
    }
}