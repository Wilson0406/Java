class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        int[][] res = new int[m][n];
        for(int[] row: res) Arrays.fill(row, Integer.MAX_VALUE);
        res[0][0] = 0;
        
        boolean[][] visited = new boolean[m][n];
        
        
        // Min heap to store time, i, j
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        pq.offer(new int[]{0, 0, 0});
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // Djikstra
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], i = curr[1], j = curr[2];
            
            if(i == m - 1 && j == n - 1) return res[i][j];
            
            if(visited[i][j]) continue;
            visited[i][j] = true;
            
            for(int dir[] : directions) {
                int x = i + dir[0], y = j + dir[1];
                
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                
                int nextTime;
                if(grid[x][y] <= time + 1) {
                    nextTime = time + 1;
                } else if((grid[x][y] - time) % 2 == 0) {
                    nextTime = grid[x][y] + 1;
                } else {
                    nextTime = grid[x][y];
                }
                
                if(nextTime < res[x][y]) {
                    res[x][y] = nextTime;
                    pq.offer(new int[]{nextTime, x, y});
                }
            }
        }
        return -1;
    }
}