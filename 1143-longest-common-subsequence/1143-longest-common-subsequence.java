class Solution {
    static int[][] dp;
    public static int helper(String s1, String s2, int index1, int index2) {
        if(index1 == s1.length() || index2 == s2.length()) {
            return 0;
        }
        if(dp[index1][index2] >= 0) {
            return dp[index1][index2];
        } 
        
        if(s1.charAt(index1) == s2.charAt(index2)) {
            dp[index1][index2] = 1 + helper(s1, s2, index1 + 1, index2 + 1);
        } else {
            dp[index1][index2] = Math.max(helper(s1, s2, index1, index2 + 1), helper(s1, s2, index1 + 1, index2));
        }
        return dp[index1][index2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        dp = new int[len1][len2];
        for (int[] row: dp)
            Arrays.fill(row, -1);
        return helper(text1, text2, 0, 0);
    }
}