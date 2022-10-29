class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        int[][] days = new int[n][2];
        for(int i = 0; i < n; i++) {
            days[i][0] = plantTime[i];
            days[i][1] = growTime[i];
        }
        
        int max = 0, plantSum = 0;
        //sort in desc order according to growTime
        Arrays.sort(days, Comparator.comparing(d -> -d[1]));
        for(int[] day: days) {
            int plant = day[0], grow = day[1];
            max = Math.max(max, plantSum + plant + grow);
            plantSum += plant;
        }
        return max;
    }
}