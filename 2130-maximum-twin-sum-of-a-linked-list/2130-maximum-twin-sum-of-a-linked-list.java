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
    void Print(ListNode head) {
        ListNode cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //to get midlle element
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        
        slow = reverse(slow);
        // Print(slow);
        // Print(fast);
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(slow!=null) {
            sum = fast.val + slow.val;
            fast = fast.next;
            slow = slow.next;
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    
    ListNode reverse(ListNode node) {
        ListNode next = null, prev = null, curr = node;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
}