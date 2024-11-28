class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];
        for(int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);
        result[0][0] = 0;
        
        // Min heap to store obstacleCount, i, j
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        
        // Directions for right, left, up and down
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Djikstra
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int obstacle = curr[0];
            int i = curr[1], j = curr[2];
            
            for(int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    int wt = (grid[x][y] == 1) ? 1 : 0;
                    
                    if(obstacle + wt < result[x][y]) {
                        result[x][y] = obstacle + wt;
                        pq.offer(new int[]{obstacle + wt, x, y});
                    }
                }
            }
            
        }
        
        return result[m - 1][n - 1];
    }
}