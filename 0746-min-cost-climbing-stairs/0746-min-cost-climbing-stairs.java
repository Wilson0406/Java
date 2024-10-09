class Solution {
    public int minCost(int i, int[] cost, int[] dp) {
        if(i < 0) return 0;
        if(i == 0 || i == 1) return cost[i];
        if(dp[i] != -1) return dp[i];
        int pay = cost[i] + Math.min(minCost(i - 1, cost, dp), minCost(i - 2, cost, dp));
        return dp[i] = pay;
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(minCost(cost.length - 1, cost, dp), minCost(cost.length - 2, cost, dp));
    }
}