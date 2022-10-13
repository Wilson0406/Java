/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // node.val -> 5, node.next.val->1
        node.val = node.next.val;
        // node.next -> node.next.val-> 9
        node.next = node.next.next;
    }
}