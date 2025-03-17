class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int count = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1) fresh++;
            }
        }

        int[] dR = {-1, 0, 1, 0};
        int[] dC = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            int t = temp[2];
            time = Math.max(t, time);
            for(int k = 0; k < 4; k++) {
                int nR = r + dR[k];
                int nC = c + dC[k];
                if(nR >= 0 && nR < n && nC >= 0 && nC < m && vis[nR][nC] == 0 && grid[nR][nC] == 1) {
                    q.add(new int[]{nR, nC, t + 1});
                    vis[nR][nC] = 2;
                    count++;
                }
            }
        }
        if(count != fresh) return -1;
        return time;
    }
}