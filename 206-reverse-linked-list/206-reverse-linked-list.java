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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return newhead;
    }
}

// Solution 2

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode cur = head;
//         ListNode prev = null;
//         while(cur!=null) {
//             ListNode temp = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = temp;
//         }
//         return prev;
//     }
// }