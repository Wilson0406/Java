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
    
    static int large(ListNode head) {
        int lar = 0;
        int h = head.val;
        if(head == null) {
            return 0;
        }
        while(head != null && head.next != null) {
            if(head.next.val > h) {
                lar = head.next.val;
                break;
            } else {
                head = head.next;
            }
        }
        return lar;
    }
        
    public int[] nextLargerNodes(ListNode head) {
        int size = size(head);
        int[] ans = new int[size+1];
        if(head == null) {
            return ans;
        }
        int i = 0;
        while(head != null && head.next != null) {
            ans[i] = large(head);
            i++;
            head = head.next;
        }
        return ans;
    }
    
    static int size(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp.next!=null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
}