class Solution {
    public int minCost(int i, int[] cost, int[] dp) {
        if(i < 0) return 0;
        if(i == 0 || i == 1) return cost[i];
        if(dp[i] != -1) return dp[i];
        int pay = cost[i] + Math.min(minCost(i - 1, cost, dp), minCost(i - 2, cost, dp));
        return dp[i] = pay;
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n < 0) return 0;
        if(n == 2) return Math.min(cost[0], cost[1]);
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = Math.min(cost[0], cost[1]);
        for(int i = 1; i < n; i++) {
            if(i < 2) dp[i] = cost[i];
            else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[n - 1], dp[n - 2]);
        // return Math.min(minCost(n - 1, cost, dp), minCost(n - 2, cost, dp));
    }
}