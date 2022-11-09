class StockSpanner {
    // span,price
    private Stack<int[]> s;
    public StockSpanner() {
        s = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!s.empty() && s.peek()[1] <= price)
            span += s.pop()[0];
        s.add(new int[]{span,price});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */