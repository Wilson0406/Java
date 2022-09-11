class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char curr = board[i][j];
                if(curr != '.') {
                    if(!set.add(curr + "found in row" + i) ||
                        !set.add(curr + "found in col" + j) ||
                        !set.add(curr + "found in box" + i/3 + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}