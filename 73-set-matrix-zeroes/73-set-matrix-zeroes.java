class Solution {
    public void setZeroes(int[][] matrix) {
        // number of rows
        int m = matrix.length;
        // number of columns
        int n = matrix[0].length;
        boolean col = false, row = false;
        
        // set 1st row and col 0 if there exists 0 in it
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) row = true;
                    if(j == 0) col = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // for row and col
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // set complete row 0 if it consists of 0
        if(col) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        // set complete col 0 if it consists of 0
        if(row) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}