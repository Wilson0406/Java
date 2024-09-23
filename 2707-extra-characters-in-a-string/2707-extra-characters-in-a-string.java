class Solution {
    int[] dp = new int[51];
    
    public int dfs(int i, String s, Set<String> dict, int n) {
        if(i >= n) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        
        int res = 1 + dfs(i + 1, s, dict, n); // skip current character
        for(int j = i; j < n; j++) {
            if(dict.contains(s.substring(i, j + 1))) {
                res = Math.min(res, dfs(j + 1, s, dict, n));
            }
        }
        return dp[i] = res;
        
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for(String st: dictionary) {
            dict.add(st);
        }
        // dp = new int[51];
        Arrays.fill(dp, -1);
        return dfs(0, s, dict, s.length());
    }
}