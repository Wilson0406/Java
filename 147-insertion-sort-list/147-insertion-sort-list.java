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
    public static int size(ListNode root) {
        int size = 0;
        while(root != null) {
            size++;
            root = root.next;
        }
        return size;
    }
    
    public ListNode insertionSortList(ListNode head) {
        int size = size(head);
        ListNode curr = head, next = null;
        ListNode temp = new ListNode(0);
        
        while(curr != null) {
            next = curr.next;
            ListNode prev = temp;
            while(prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return temp.next;
    }
}