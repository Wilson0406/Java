class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxsum = Integer.MIN_VALUE;
        int[] arr = new int[m];
        
        for(int left = 0; left < n; left++) {
            Arrays.fill(arr,0);
            for(int right = left; right < n; right++) {
                //add row to new array
                for(int row = 0; row < m; row++) {
                    arr[row] += matrix[row][right];
                }
                int currsum = kadane(arr,k);
                maxsum = Math.max(maxsum, currsum);
            }
        }
        return maxsum;
        
    }
    public static int kadane(int[] arr, int k) {
        int len = arr.length;
        int maxS = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++) {
            int max = 0;
            for(int j = i; j < len; j++) {
                max += arr[j];
                if(max <= k)
                    maxS = Math.max(maxS, max);
            }
            
        }
        return maxS;
    }
}    