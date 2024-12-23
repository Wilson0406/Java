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
    public int countMinSwap(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        int swaps = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == sorted.get(i)) continue; // No swap needed
            int currIdx = map.get(sorted.get(i));
            map.put(list.get(i), currIdx);
            int temp = list.get(currIdx);
            list.set(currIdx, list.get(i));
            list.set(i, temp);
            swaps++;
        }
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                TreeNode temp = q.poll();
                list.add(temp.val);
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                
                
            }
            res += countMinSwap(list);
        }
        return res;   
    }
}