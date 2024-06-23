class Solution {
  public int minimumArea(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    // minimum of [x, y]
    int[] min = new int[] {m, n};
    // maximum of [x, y]
    int[] max = new int[] {0, 0};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          min[0] = Math.min(min[0], i);
          min[1] = Math.min(min[1], j);
          max[0] = Math.max(max[0], i);
          max[1] = Math.max(max[1], j);
        }
      }
    }

    return (max[0] - min[0] + 1) * (max[1] - min[1] + 1);
  }
}