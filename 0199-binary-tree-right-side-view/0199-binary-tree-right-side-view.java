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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // BFS, add the last element of the queue in each pass
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if(i == size - 1) {
                    ans.add(current.val);
                }
                // add left subtree to the queue if not null
                if(current.left != null) {
                    queue.add(current.left);
                }
                // add right subtree to the queue if not null
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return ans;
    }
}