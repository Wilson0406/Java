class Solution {
    public void dfs(int i, int j, int[][] vis, int[][] grid, int[] dR, int[] dC) {
        vis[i][j] = 1;
        
        for(int k = 0; k < 4; k++) {
            int nR = i + dR[k];
            int nC = j + dC[k];
            if(nR >= 0 && nR < grid.length && nC >= 0 && nC < grid[0].length && vis[nR][nC] == 0 && grid[nR][nC] == 1) {
                dfs(nR, nC, vis, grid, dR, dC);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delR = { -1, 0, 1, 0 };
        int[] delC = { 0, 1, 0, -1 };
        int[][] vis = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            // 1st col
            if(vis[i][0] == 0 && grid[i][0] == 1) dfs(i, 0, vis, grid, delR, delC);
            
            // last col
            if(vis[i][m - 1] == 0 && grid[i][m - 1] == 1) dfs(i, m - 1, vis, grid, delR, delC);
        }
        
        for(int j = 0; j < m; j++) {
            // 1st row
            if(vis[0][j] == 0 && grid[0][j] == 1) dfs(0, j, vis, grid, delR, delC);
            
            // last row
            if(vis[n - 1][j] == 0 && grid[n - 1][j] == 1) dfs(n - 1, j, vis, grid, delR, delC);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}