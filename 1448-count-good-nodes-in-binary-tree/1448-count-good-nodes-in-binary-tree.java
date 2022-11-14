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
    public int count(TreeNode root, int value) {
        if(root == null) {
            return 0;
        }
        int res = root.val < value ? 0 : 1;
        int left = count(root.left, Math.max(root.val,value));
        int right = count(root.right, Math.max(root.val,value));
        return res + left + right;
    }
    public int goodNodes(TreeNode root) {
        return count(root, root.val);
    }
}