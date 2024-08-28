class Solution {
    int flag = 0;
    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if(i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length) return;
        if (grid2[i][j] != 1) return;
        if(grid2[i][j] == 1) {
            if(grid1[i][j] == 0) flag = 0;
            grid2[i][j] = 0;
        }
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i, j - 1);
        dfs(grid1, grid2, i, j + 1);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0; i < grid2.length; i++) {
            for(int j = 0; j < grid2[0].length; j++) {
                if(grid2[i][j] == 1) {
                    flag = 1;
                    dfs(grid1, grid2, i, j);
                    count += flag;
                }
            }
        }
        return count;
    }
}