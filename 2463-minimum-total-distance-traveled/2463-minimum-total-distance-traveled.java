class Solution {
    private static long max = 10000000000000L;
    public long minCost(int robPos, int facPos, List<Integer> robot, List<Integer> factories, long[][] dp) {
        if(robPos < 0) return 0;
        if(facPos < 0) return max;
        if(dp[robPos][facPos] != -1) return dp[robPos][facPos];
        
        long include = Math.abs(robot.get(robPos) - factories.get(facPos)) + minCost(robPos - 1, facPos - 1, robot, factories, dp);
        long exclude = minCost(robPos, facPos - 1, robot, factories, dp);
        
        return dp[robPos][facPos] = Math.min(include, exclude);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        // Converting multi instance factory to single instance
        List<Integer> factories = new ArrayList<>();
        for(int[] fact : factory) {
            int pos = fact[0];
            int count = fact[1];
            for(int i = 0; i < count; i++) {
                factories.add(pos);
            }
        }
        
        long[][] dp = new long[robot.size()][factories.size()];
        for(long[] d : dp) Arrays.fill(d, -1);
        return minCost(robot.size() - 1, factories.size() - 1, robot, factories, dp);
    }
}