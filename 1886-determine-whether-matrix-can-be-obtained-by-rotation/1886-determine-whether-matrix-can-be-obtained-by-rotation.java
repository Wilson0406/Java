class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int[][] res1 = new int[n][n];
        int[][] res2 = new int[n][n];
        int[][] res3 = new int[n][n];
        
        // 90 degrees
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res1[i][j] = mat[n-j-1][i];
            }
        }
        
        // 180 degrees
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res2[i][j] = res1[n-j-1][i];
            }
        }
        
        // 270 degrees
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res3[i][j] = res2[n-j-1][i];
            }
        }
        
        if(Arrays.deepEquals(target, res1) || Arrays.deepEquals(target, res2) || Arrays.deepEquals(target, res3) || Arrays.deepEquals(target, mat)){
            return true;
        }
        return false;
    }
}