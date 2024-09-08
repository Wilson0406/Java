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
    public int length(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int len = length(head);
        ListNode[] ans = new ListNode[k];
        int value = len / k;
        int extra = len % k;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        temp = head;
        for(int i = 0; i < k; i++) {
            int j = value + (i < extra ? 1 : 0);
            ListNode before = prev;
            while(j-- > 0) {
                prev = temp;
                temp = temp.next;
            }
            ans[i] = before.next;
            before.next = null;
        }
        
        return ans;
    }
}