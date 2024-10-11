class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int chair[] = new int[times.length];
        Arrays.fill(chair, -1);
        int targetArrivalTime = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int time[]: times) {
            int arrival = time[0];
            int depart = time[1];
            
            for(int i = 0; i < times.length; i++) {
                if(chair[i] <= arrival) {
                    chair[i] = depart;
                    
                    if(arrival == targetArrivalTime) {
                        return i;
                    }
                break;
                }
            }
        }
        return -1;
    }
}