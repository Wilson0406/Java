/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        ListNode temp = head;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        
        int len = m * n;
        int count = 0;
        int val = 0;
        while(count < len) {
            
            // Left to right
            for(int i = left; i <= right && count < len; i++) {
                if(temp!= null) {
                    val = temp.val;
                    temp = temp.next;
                } else {
                    val = -1;
                }
                ans[top][i] = val;
                count++;
            }
            top++;
            
            // Top to bottom
            for(int i = top; i <= bottom && count < len; i++) {
                if(temp!= null) {
                    val = temp.val;
                    temp = temp.next;
                } else {
                    val = -1;
                }
                ans[i][right] = val;
                count++;
            }
            right--;
            
            //Right to left
            for(int i = right; i >= left && count < len; i--) {
                if(temp!= null) {
                    val = temp.val;
                    temp = temp.next;
                } else {
                    val = -1;
                }
                ans[bottom][i] = val;
                count++;
            }
            bottom--;
            
            // Bottom to top
            for(int i = bottom; i >= top && count < len; i--) {
                if(temp!= null) {
                    val = temp.val;
                    temp = temp.next;
                } else {
                    val = -1;
                }
                ans[i][left] = val;
                count++;
            }
            left++;
        }
        
        return ans;
    }
}