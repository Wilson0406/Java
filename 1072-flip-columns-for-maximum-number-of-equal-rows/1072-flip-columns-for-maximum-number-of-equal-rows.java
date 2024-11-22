class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int maxRows = 0;
        for(int[] currRow : matrix) { // O(m * (n + m * n))
            int[] inverted = new int[n];
            
            for(int col = 0; col < currRow.length; col++) { // O(n)
                inverted[col] = currRow[col] == 0 ? 1 : 0;
            }
            
            int count = 0;
            for(int[] row : matrix) { // O(m * n)
                if(Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) { // O(n)
                    count++;
                }
            }
            
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }
}