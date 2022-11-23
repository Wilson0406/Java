class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
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