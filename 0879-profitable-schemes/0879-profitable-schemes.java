class Solution {
    private int mod = (int)1e9 + 7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][][] dp = new int[group.length + 1][G + 1][P + 1];
        dp[0][0][0] = 1;
        for (int k = 1; k <= group.length; k++) {
            int g = group[k - 1];
            int p = profit[k - 1];
            for (int i = 0; i <= G; i++) {
                for (int j = 0; j <= P; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (i >= g) {
                        dp[k][i][j] = (dp[k][i][j] + dp[k - 1][i - g][Math.max(0, j - p)])%mod;
                    }
                }
            }
        }
        int sum = 0;                                                       
        for(int i = 0; i <= G; i++){
            sum = (sum + dp[group.length][i][P])%mod;
        }
        return sum;
    }
}