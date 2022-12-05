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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int i = 0, middle;
        int arr[] = new int[count];
        while(temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }
        if (count%2 != 0){
            middle = (count + 1)/2;
        }
        else {
            middle = (count/2);
        }
        
            int mid[] = new int[middle];
            for(int j = middle; j<count;j++) {
                head = head.next;
            }
        return head;
    }
}