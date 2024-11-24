class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int count = 0;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sum += Math.abs(matrix[i][j]);
                smallest = Math.min(smallest, Math.abs(matrix[i][j]));
                if(matrix[i][j] <= 0) {
                    count++;
                }
            }
        }
        
        if(count % 2 != 0) {
            sum -= 2 * smallest;
        }
        // System.out.println(smallest);
        return sum;
    }
}