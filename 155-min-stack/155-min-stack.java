class MinStack {

    Stack<Integer> stacks = new Stack<>();
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        //Stack<Integer> stacks = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min) {
            stacks.push(min);
            min = val;
            
        }
        stacks.push(val);
    }
    
    public void pop() {
        if(stacks.pop() == min)
            min = stacks.pop();
    }
    
    public int top() {
        if(stacks.size() == 0) return 0;
        return stacks.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */