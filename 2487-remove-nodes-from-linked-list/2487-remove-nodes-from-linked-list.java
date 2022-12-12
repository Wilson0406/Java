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
    public ListNode reverse(ListNode head) {
        // if(head == null) {
        //     return null;
        // }
        if(head.next == null) {
            return head;
        }
        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode curr = head, prev = head;
        int max = head.val;
        while(curr != null) {
            max = Math.max(max, curr.val);
            if(max > curr.val) {
                prev.next = prev.next.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        
        return reverse(head);
    }
}