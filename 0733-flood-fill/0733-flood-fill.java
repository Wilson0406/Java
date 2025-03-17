class Solution {
    public void dfs(int r, int c, int[][] ans, int[][] image, int ini, int[] delR, int[] delC, int newC) {
        ans[r][c] = newC;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i < 4; i++) {
            int nR = r + delR[i];
            int nC = c + delC[i];
            if(nR >= 0 && nR < n && nC >= 0 && nC < m && image[nR][nC] == ini && ans[nR][nC] != newC) {
                dfs(nR, nC, ans, image, ini, delR, delC, newC);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int ini = image[sr][sc];
        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, ini, delR, delC, color);
        return ans;
    }
}