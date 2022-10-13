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
    int sum = 0;
    List<Integer> list = new ArrayList<>();
    public void range(TreeNode root, int low, int high) {
        if(root == null) {
            return;
        }
        if(root.val >= low && root.val <= high) {
            range(root.left, low, high);
            // list.add(root.val);
            sum += root.val;
            range(root.right, low, high);
        } else if(root.val >= high) {
            range(root.left, low, high);
        } else {
            range(root.right, low, high);
        }
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        range(root, low, high);
        // int sum = 0;
        // for(int i = 0; i < list.size(); i++) {
        //     sum += list.get(i);
        // }
        return sum;
    }
}