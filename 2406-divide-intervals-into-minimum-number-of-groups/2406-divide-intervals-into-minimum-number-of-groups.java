class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int interval[] : intervals) {
            int arrival = interval[0];
            int departure = interval[1];
            
            if(!heap.isEmpty() && heap.peek() < arrival) {
                heap.poll();
            }
            heap.add(departure);
        }
        
        return heap.size();
    }
}