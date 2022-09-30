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
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }
    
    public int sum(TreeNode root, int depth, int sum) {
        if(depth == 1 && root != null) {
            sum += root.val;
            return sum;
        }
        if(root == null) {
            return 0;
        }
        int left = sum(root.left, depth - 1, sum);
        int right = sum(root.right, depth - 1, sum);
        return (left + right);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        int depth = depth(root);
        return sum(root, depth, 0);
    }
}