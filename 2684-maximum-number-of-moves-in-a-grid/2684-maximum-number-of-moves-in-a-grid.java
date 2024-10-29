class Solution {
    int m;
    int n;
    int direction[] = {-1, 0, 1};
    public int dfs(int r, int c, int[][] grid, int[][] dp) {
        int moves = 0;
        if(dp[r][c] != -1) return dp[r][c];
        for(int d : direction) {
            int row = r + d;
            int col = c + 1;
            if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] > grid[r][c]) {
                moves = Math.max(moves, 1 + dfs(row, col, grid, dp));
            }
        }
        return dp[r][c] = moves;
    }
    public int maxMoves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        for(int d[] : dp) {
            Arrays.fill(d, -1);
        }
        for(int row = 0; row < m; row++) {
            res = Math.max(res, dfs(row, 0, grid, dp));
        }
        return res;
    }
}