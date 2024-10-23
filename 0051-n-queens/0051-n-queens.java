class Solution {
    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public boolean isSafe(int row, int col, char[][] board, int n) {
        int duprow = row;
        int dupcol = col;
        
        // Upper left
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        // Left
        while(col >= 0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        // Lower left
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    public void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if(col == n) {
            ans.add(construct(board));
            return;
        }
        
        for(int row = 0; row < n; row++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }
    
    public void solve2(int col, char[][] board, List<List<String>> ans, int n, int[] left, int[] upperleft, int[] lowerleft) {
        if(col == n) {
            ans.add(construct(board));
            return;
        }
        
        for(int row = 0; row < n; row++) {
            if(left[row] == 0 && upperleft[row + col] == 0 && lowerleft[n - 1 + row - col] == 0) {
                board[row][col] = 'Q';
                left[row] = 1;
                upperleft[row + col] = 1;
                lowerleft[n - 1 + row - col] = 1;
                solve2(col + 1, board, ans, n, left, upperleft, lowerleft);
                board[row][col] = '.';
                left[row] = 0;
                upperleft[row + col] = 0;
                lowerleft[n - 1 + row - col] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // function isSafe is another O(n)
        // solve(0, board, ans, n);
        
        int[] left = new int[n];
        int[] upperleft = new int[2 * n - 1];
        int[] lowerleft = new int[2 * n - 1];
        solve2(0, board, ans, n, left, upperleft, lowerleft);
        return ans;
    }
}