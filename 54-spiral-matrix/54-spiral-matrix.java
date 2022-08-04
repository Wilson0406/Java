class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;
        List<Integer> out = new ArrayList<>();
        
        // while(out.size() < n*m) {
        while(left <= right && up <= down) {
            // left to right
            for(int i = left; i <= right && out.size() < n*m; i++)
                out.add(matrix[up][i]);
            
            // top to bottom 
            for(int j = up + 1; j <= down - 1 && out.size() < n*m; j++)
                out.add(matrix[j][right]);
            
            // right to left
            for(int i = right; i >= left && out.size() < n*m; i--)
                out.add(matrix[down][i]);
            
            // bottom to up
            for(int j = down - 1; j >= up + 1 && out.size() < n*m; j--)
                out.add(matrix[j][left]);
            
            left++;
            right--;
            up++;
            down--;
        }
        return out;
    }
}