class Solution {
    public void dfs(int i, int j, char[][] board, int[][] vis, int[] row, int[] col) {
        vis[i][j] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int k = 0; k < 4; k++) {
            int r = i + row[k];
            int c = j + col[k];
            if(r >= 0 && r < n && c >= 0 && c < m && vis[r][c] == 0 && board[r][c] == 'O') {
                dfs(r, c, board, vis, row, col);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        
        // 1st and last row
        for(int j = 0; j < m; j++) {
            if(vis[0][j] == 0 && board[0][j] == 'O') dfs(0, j, board, vis, row, col);
            if(vis[n - 1][j] == 0 && board[n - 1][j] == 'O') dfs(n - 1, j, board, vis, row, col);
        }

        // 1st and last col
        for(int i = 0; i < n; i++) {
            if(vis[i][0] == 0 && board[i][0] == 'O') dfs(i, 0, board, vis, row, col);
            if(vis[i][m - 1] == 0 && board[i][m - 1] == 'O') dfs(i, m - 1, board, vis, row, col);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}