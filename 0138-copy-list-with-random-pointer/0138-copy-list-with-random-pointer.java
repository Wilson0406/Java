/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Node curr = head;
        
        Map<Node,Node> map = new HashMap<>();
        
        while(curr != null) {
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        
        for(Node key: map.keySet()) {
            Node newNode = map.get(key);
            newNode.next = map.get(key.next);
            newNode.random = map.get(key.random);
        }
        return map.get(head);
    }
}