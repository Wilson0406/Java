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
    int[] height = new int[100001];
    int[] level = new int[100001];
    int[] levelMaxHt = new int[100001];
    int[] levelSecondMaxHt = new int[100001];
    public int findHeight(TreeNode root, int l) {
        if(root == null) return 0;
        level[root.val] = l;
        height[root.val] = Math.max(findHeight(root.left, l + 1), findHeight(root.right, l + 1)) + 1;
        
        if(levelMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = height[root.val];
        } else if(levelSecondMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = height[root.val];
        }
        return height[root.val];
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        findHeight(root, 0);
        int i = 0;
        for(int node : queries) {
            int L = level[node];
            int H = levelMaxHt[L] == height[node] ? levelSecondMaxHt[L] : levelMaxHt[L];
            int tempRes = L + H - 1;
            ans[i++] = tempRes;
        }
        return ans;
    }
}