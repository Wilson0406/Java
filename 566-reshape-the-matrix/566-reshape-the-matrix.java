class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int x = mat.length;
        int y = mat[0].length;
        if(x*y != r*c)
            return mat;
        int [][] res = new int[r][c];
        for(int i = 0; i < r*c; i++) {
            res[i/c][i%c] = mat[i/y][i%y];
        }
        return res;
    }
}