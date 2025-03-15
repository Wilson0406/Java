class Solution {
    public int count(int i, int[] coins, int sum, int[][] dp) {
        if(i == 0) {
            if(sum % coins[0] == 0) return sum / coins[0];
            else return 1000000009;
        }

        if(dp[i][sum] != -1) return dp[i][sum];
        int not = count(i - 1, coins, sum, dp);
        int take = Integer.MAX_VALUE;
        if(sum >= coins[i]) take = 1 + count(i, coins, sum - coins[i], dp);
        return dp[i][sum] = Math.min(take, not);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int r[]: dp) Arrays.fill(r, -1);
        int ans = count(n - 1, coins, amount, dp);
        return ans >= 1000000009 ? -1 : ans;
    }
}