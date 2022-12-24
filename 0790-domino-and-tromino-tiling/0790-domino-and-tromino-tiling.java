class Solution {
    public int numTilings(int n) {
        int mod = 1_000_000_007;
        if(n < 2) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-1]*2)%mod + (dp[i-3]));
            dp[i] %= mod;
        }
        return dp[n]%mod;
    }
}

// 1 2 3  4  5  6   7   8   9   10
// 1 2 5 11 24 53 117 258 569 1255