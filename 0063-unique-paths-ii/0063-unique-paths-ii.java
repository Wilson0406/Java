class Solution {
    int m, n;
    public int solve(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = solve(i - 1, j, obstacleGrid, dp);
        int left = solve(i, j - 1, obstacleGrid, dp);
        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int row[]: dp) {
            Arrays.fill(row, -1);
        }
        return solve(m - 1, n - 1, obstacleGrid, dp);
    }
}