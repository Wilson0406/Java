class Solution {
    public int f(int idx, String s, int[] dp) {
        if(idx == s.length()) return 1;
        if(dp[idx] != -1) return dp[idx];
        if(s.charAt(idx) == '0') return dp[idx] = 0;
        int res = f(idx + 1, s, dp);
        if(idx < s.length() - 1 && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6')) res += f(idx + 2, s, dp);
        
        return dp[idx] = res;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(0, s, dp);
    }
}