class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int current = startFuel;
        int count = 0;
        //Max heap on the basis of fuel value
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->(b-a));
        
        for(int[] station: stations) {
            int nextStation = station[0];
            int fuel = station[1];
            
            // exhaust all fuel
            while(current < nextStation) {
                if(pq.isEmpty()) {
                    return -1;
                }
                int maxfuel = pq.poll();
                current += maxfuel;
                count++;
            }
            //add fuel in pq
            pq.offer(fuel);
        }
        //
        while(current < target) {
            if(pq.isEmpty()) {
                    return -1;
            }
            int maxfuel = pq.poll();
                current += maxfuel;
                count++;
        }
        return count;
    }
}