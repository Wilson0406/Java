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
    public int gcd(int a, int b) {
      if(b == 0)
        return a;
      return gcd(b, a % b); 
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while(temp2 != null) {
            int c = gcd(temp1.val, temp2.val);
            ListNode t = new ListNode(c);
            temp1.next = t;
            t.next = temp2;
            
            temp1 = temp2;
            temp2 = temp2.next;
        }
        return head;
    }
}