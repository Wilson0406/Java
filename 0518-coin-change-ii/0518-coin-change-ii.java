class Solution {
    public int count(int i, int sum, int[] coins, int[][] dp) {
        if(i == 0) {
            if(sum % coins[i] == 0) return 1;
            else return 0;
        }

        if(dp[i][sum] != -1) return dp[i][sum];

        int not = count(i - 1, sum, coins, dp);
        int take = 0;
        if(sum >= coins[i]) take = count(i, sum - coins[i], coins, dp);

        return dp[i][sum] = take + not;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int[] r : dp) Arrays.fill(r, -1);
        return count(n - 1, amount, coins, dp);
    }
}