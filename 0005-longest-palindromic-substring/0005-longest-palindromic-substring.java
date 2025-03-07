class Solution {
    public boolean solve(String s, int i, int j, int[][] dp) {
        if(i >= j) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(s, i + 1, j - 1, dp) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        int max = Integer.MIN_VALUE, sp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(solve(s, i, j, dp) && (j - i + 1) > max) {
                    max = j - i + 1;
                    sp = i;
                }
            }
        }
        return s.substring(sp, max + sp);
    }
}