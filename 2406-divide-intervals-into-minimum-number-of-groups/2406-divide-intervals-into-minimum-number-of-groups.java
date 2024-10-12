class Solution {
    public int minGroups(int[][] intervals) {
            // Using heaps
//         Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
//         PriorityQueue<Integer> heap = new PriorityQueue<>();
//         for(int interval[] : intervals) {
//             int arrival = interval[0];
//             int departure = interval[1];
            
//             if(!heap.isEmpty() && heap.peek() < arrival) {
//                 heap.poll();
//             }
//             heap.add(departure);
//         }
        
//         return heap.size();
        
        // Line sweep
        int line[] = new int[1000005];
        int max = -1;
        for(int interval[]: intervals) {
            line[interval[0]]++;
            line[interval[1] + 1]--;
        }
        
        for(int i = 1; i < 1000001; i++) {
            line[i] += line[i - 1];
            max = Math.max(max, line[i]);
        }
        return max;
    }
}