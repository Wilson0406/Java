class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // Brute force
//         int chair[] = new int[times.length];
//         Arrays.fill(chair, -1);
//         int targetArrivalTime = times[targetFriend][0];
//         Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        
//         for(int time[]: times) {
//             int arrival = time[0];
//             int depart = time[1];
            
//             for(int i = 0; i < times.length; i++) {
//                 if(chair[i] <= arrival) {
//                     chair[i] = depart;
                    
//                     if(arrival == targetArrivalTime) {
//                         return i;
//                     }
//                 break;
//                 }
//             }
//         }
//         return -1;
        
        // Using Heaps
        int n = times.length;
        int targetArrivalTime = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> free = new PriorityQueue<>();
        
        int chairNo = 0;
        for(int i = 0; i < n; i++) {
            int arrival = times[i][0];
            int depart = times[i][1];
            
            while(!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                free.offer(occupied.poll()[1]);
            }
            if(free.isEmpty()) {
                occupied.offer(new int[]{depart, chairNo});
                if(arrival == targetArrivalTime) {
                    return chairNo;
                }
                chairNo++;
            } else {
                int leastChairNo = free.poll();
                if(arrival == targetArrivalTime) {
                    return leastChairNo;
                }
                occupied.offer(new int[]{depart, leastChairNo});
            }
            
        }
        return -1;
    }
}