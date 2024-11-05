class Solution {
    int n;
    public int solve(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if(i == n - 1) return triangle.get(n - 1).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + solve(i + 1, j, triangle, dp);
        int diag = triangle.get(i).get(j) + solve(i + 1, j + 1, triangle, dp);
        
        // return Math.min(down, diag);
        return dp[i][j] = Math.min(down, diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        int[][] dp = new int[n][n];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        for(int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
        // return solve(0, 0, triangle, dp);
    }
}