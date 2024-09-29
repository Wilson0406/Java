
class AllOne {
    private class Node {
        int count;
        LinkedHashSet<String> keys;
        Node prev;
        Node next;
        Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
            prev = null;
            next = null;
        }
    }
    Map<String, Node> map;
    Node head; // Head.next will be front -> to get MinKey
    Node last; // To get MaxKey

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        last = new Node(0);
        head.next = last;
        last.prev = head;
    }
    
    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    void addNode(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        newNode.next.prev = newNode;
        prevNode.next = newNode;
    }
    
    public void inc(String key) {
        // key is not present
        if(!map.containsKey(key)) {
            if(head.next == null || head.next.count != 1) {
                addNode(head, 1);
            }
            head.next.keys.add(key);
            map.put(key, head.next);
        } else { // Key is present in map, increase the count
            Node currNode = map.get(key);
            int currCount = currNode.count;
            if(currNode.next == last || currNode.next.count != currCount + 1) {
                addNode(currNode, currCount + 1);
            }
            currNode.next.keys.add(key);
            map.put(key, currNode.next);
            currNode.keys.remove(key);
            if(currNode.keys.isEmpty()) {
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node currNode = map.get(key);
        int currCount = currNode.count;
        
        currNode.keys.remove(key);
        
        if(currCount == 1) {
            map.remove(key);
        } else {
            if(currNode.prev == head || currNode.prev.count != currCount - 1) {
                addNode(currNode.prev, currCount - 1);
            }
            currNode.prev.keys.add(key);
            map.put(key, currNode.prev);
        }
        
        if(currNode.keys.isEmpty()) {
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() {
        if(last.prev == head) return "";
        return last.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == last) return "";
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */