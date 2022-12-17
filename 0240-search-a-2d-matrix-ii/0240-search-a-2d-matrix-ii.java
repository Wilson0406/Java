class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r  = matrix[0].length - 1;
            while(l <= r) {
                    int mid = l + (r-l)/2;
                    if(matrix[i][mid] == target) return true;
                    if(matrix[i][mid] > target)
                        r = mid - 1;
                    else
                        l = mid + 1;
                }
        }
        return false;
    }
}