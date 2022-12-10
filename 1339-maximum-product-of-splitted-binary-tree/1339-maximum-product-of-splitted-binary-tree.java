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
    long total = 0, ans = 0;
    public long find(TreeNode root) {
        if(root == null) {
            return 0;
        }
        long sum = find(root.left) + find(root.right) + root.val;
        ans = Math.max(ans, (total-sum)*sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        total = find(root);
        find(root);
        return (int)(ans % ((int)Math.pow(10, 9) + 7));
    }
}