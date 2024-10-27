class Solution {
    // Top Down
//     int m, n;
//     public int solve(int i, int j, int[][] matrix, int[][] dp) {
//         if(i >= m || j >= n) return 0;
//         if(matrix[i][j] == 0) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
        
//         int right = solve(i, j + 1, matrix, dp);
//         int diag = solve(i + 1, j + 1, matrix, dp);
//         int below = solve(i + 1, j, matrix, dp);
//         return dp[i][j] = 1 + Math.min(right, Math.min(diag, below));
        
//     }
//     public int countSquares(int[][] matrix) {
//         m = matrix.length;
//         n = matrix[0].length;
//         int res = 0;
//         int dp[][] = new int[m + 1][n + 1];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(matrix[i][j] == 1) {
//                     res += solve(i, j, matrix, dp);
//                 }
//             }
//         }
//         return res;
//     }
    // Bottom up
    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
                
                res+= dp[i][j];
            }
        }
        return res;
    }
}