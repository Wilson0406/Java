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
    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> smallAns) {
        
        if(root == null)return;
        
        if(root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                // deep copy
                List<Integer> base = new ArrayList<>(smallAns);
                base.add(root.val);
                ans.add(base);
            }
            return;
        }
        
        smallAns.add(root.val);
        
        // check left subtree
        pathSum(root.left, targetSum - root.val, ans, smallAns);
        // check right subtree
        pathSum(root.right, targetSum - root.val, ans, smallAns);
        
        //backtrack if target sum is not achieved
        smallAns.remove(smallAns.size() - 1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        pathSum(root, targetSum, ans, smallAns);
        return ans;
    }
}