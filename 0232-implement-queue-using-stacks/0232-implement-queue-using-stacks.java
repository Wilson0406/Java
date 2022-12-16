class MyQueue {

    Stack<Integer> queue = new Stack<>();
    Stack<Integer> queueb = new Stack<>();
    public MyQueue() {
        // Stack<Integer> queue = new Stack<>();
        // Stack<Integer> queueb = new Stack<>();
    }
    
    public void push(int x) {
        queue.push(x);
    }
    
    public int pop() {
        while(!queue.isEmpty()) {
            queueb.push(queue.pop());
        }
        int out = queueb.pop();
        while(!queueb.isEmpty()) {
            queue.push(queueb.pop());
        }
        return out;
    }
    
    public int peek() {
        while(!queue.isEmpty()) {
            queueb.push(queue.pop());
        }
        int out = queueb.peek();
        while(!queueb.isEmpty()) {
            queue.push(queueb.pop());
        }
        return out;
    }
    
    public boolean empty() {
        return queue.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */