class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        long sum = 0;
        Arrays.sort(maximumHeight);
        int LastMin = Integer.MAX_VALUE;
        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            int currentHeight = Math.min(maximumHeight[i], LastMin - 1);
            if(currentHeight < 1) return -1;
            
            sum += currentHeight;
            LastMin = currentHeight;
        }
        return sum;
    }
}