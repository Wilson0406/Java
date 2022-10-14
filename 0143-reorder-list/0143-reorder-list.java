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


/*
Divide the list in two halves, reverse the second half and merge the two lists
*/
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            l1.next = l2;
            if(l1_next == null) {
                break;
            }
            
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        // head of first half
        ListNode l1 = head;
        // tail of first half
        ListNode prev = null;
        // head of second half
        ListNode slow = head;
        // tail of second half
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        // reverse the second half
        ListNode l2 = reverse(slow);
        // merge the two lists
        merge(l1,l2);
    }
}