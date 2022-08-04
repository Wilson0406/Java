class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        //find the row
        int top = 0;
        int bottom = row - 1;
        while(top <= bottom) {
            int mid = (top + bottom)/2;
            if(matrix[mid][matrix[0].length - 1] < target)
                top = mid + 1;
            else if(matrix[mid][0] > target)
                bottom = mid - 1;
            else
                break;
        }
        
        row = (top + bottom)/2;
        int l = 0;
        int r = col - 1;
        while(l <= r) {
            int mid = (l + r)/2;
            if(matrix[row][mid] < target)
                l = mid + 1;
            else if(matrix[row][mid] > target)
                r = mid - 1;
            else
                return true;
        }
        return false;
    }
}