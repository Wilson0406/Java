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
    static int size(ListNode head) {
        int size = 0;
        while(head!=null) {
            size++;
            head = head.next;
        }
        return size;
    }
        
    public ListNode swapNodes(ListNode head, int k) {
//         int size = size(head);
//         int arr[] = new int[size];
//         int i = 0;
//         while(head != null && head.next != null) {
//             arr[i] = head.val;
//             head = head.next;
//             i++;
//         }
//         int temp1 = arr[k-1];
//         int temp2 = arr[size-k+1];
//         arr[k-1] = temp2;
//         arr[size-k+1] = temp1;
        
//         ListNode ans = new ListNode(-1);
//         for(i = 0; i < size; i=i+2) {
//             ans.val = arr[i];
//             ans.next.val = arr[i+1];
//         }
//         ans.next = null;
//         return ans.next;
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = null;
        ListNode second = null;
        int count = 1;
        while(fast != null && count < k) {
            fast = fast.next;
            count++;
        }
        first = fast;
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;
        // swapping
        int ans = first.val;
        first.val = second.val;
        second.val = ans;
        
        return head;
    }
}