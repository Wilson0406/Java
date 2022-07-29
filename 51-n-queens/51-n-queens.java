class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Positions for all the queens
        List<int[]> queens = new ArrayList<>();
        dfs(board, 0, queens);
        return result;
    }
    
    private void dfs(char[][] board, int r, List<int[]> queens) {
        // If queens are placed
        if(queens.size() == board.length) {
            List<String> rows = new ArrayList<>();
            for(char[] row: board) {
                rows.add(new String(row));
            }
            result.add(rows);
        }
        
        // Place queens
        for(int c=0; c<board.length; c++) {
            if(isQueenSafe(r,c,queens)) {
                board[r][c] = 'Q';
                // Update queen's list
                queens.add(new int[]{r,c});
                
                // Next Row
                dfs(board, r+1, queens);
                
                // Backtrack
                board[r][c] = '.';
                // and then remove the queen that was added previously
                queens.remove(queens.size() - 1);
            }
        }
    }
    
    private boolean isQueenSafe(int r, int c, List<int[]> queens) {
        for(int[] q: queens) {
            int dx = Math.abs(r-q[0]);
            int dy = Math.abs(c-q[1]);
            if(dx == 0 || dy == 0 || dx == dy) return false;
        }
        return true;
    }
}