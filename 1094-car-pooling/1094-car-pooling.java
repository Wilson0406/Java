class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] time = new int[1001];
        for(int t[]: trips) {
            // Add the number of passengers at starting point            
            time[t[1]] += t[0];
            // Remove the number of passengers from dropping point  
            time[t[2]] -= t[0];
        }
        for(int i=0;i<1001;i++) {
            capacity -= time[i];
            if(capacity<0) return false;
        }
        return true;
    }
}