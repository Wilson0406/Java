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
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(root1, list1);
        helper(root2, list2);
        return list1.equals(list2);
    }
    public void helper(TreeNode node, List<Integer> list) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                list.add(node.val);
            }
            helper(node.left, list);
            helper(node.right, list);
        }
    }
}


// class Solution {
    
//     public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//         if(root1 == null || root2 == null) {
//             return false;
//         }
//         StringBuilder sb1 = new StringBuilder();
//         StringBuilder sb2 = new StringBuilder();
//         helper(root1, sb1);
//         helper(root2, sb2);
//         return sb1.equals(sb2);
//     }
//     public void helper(TreeNode node, StringBuilder sb) {
//         if(node != null) {
//             if(node.left == null && node.right == null) {
//                 sb.append(Integer.toString(node.val));
//             }
//             helper(node.left, sb);
//             helper(node.right, sb);
//         }
//     }
// }