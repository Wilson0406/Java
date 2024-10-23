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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // Calculate level sum for every level using BFS
        while(!q.isEmpty()) {
            int sum = 0;
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                sum += node.val;
            }
            level.add(sum);
        }
        q.add(root);
        root.val = 0;
        int i = 1; // Since we will start from next level after root
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                int siblingSum = node.left != null ? node.left.val : 0;
                siblingSum += node.right != null ? node.right.val : 0;
                
                if(node.left != null) {
                    node.left.val = level.get(i) - siblingSum;
                    q.add(node.left);
                }
                if(node.right != null) {
                    node.right.val = level.get(i) - siblingSum;
                    q.add(node.right);
                }
            }
            i++;
        }
        
        return root;
    }
}