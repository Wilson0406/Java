class MedianFinder {
    // two priority queues
    // large with more elements
    PriorityQueue<Integer> right;
    // small
    PriorityQueue<Integer> left;
    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        right.offer(num);
        left.offer(right.poll());
        if(right.size() < left.size()) {
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        
        if (left.size() < right.size())
            return right.peek();
 
        return (double)(right.peek() + left.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// 1 2 3
// max  min
// [1] [2, 3]