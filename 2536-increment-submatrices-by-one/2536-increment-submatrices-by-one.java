class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][]mat = new int[n][n];
        int[][] prefix = new int[n+1][n+1];
        
        for(int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            prefix[row1][col1] += 1;
            prefix[row2 + 1][col2 + 1] += 1;
            prefix[row1][col2 + 1] -= 1;
            prefix[row2 + 1][col1] -= 1;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                prefix[i][j+1] += prefix[i][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                prefix[i+1][j] += prefix[i][j];
                mat[i][j] = prefix[i][j];
            }
        }
        return mat;
    }
}