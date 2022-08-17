class Solution {
    // public boolean checkValid(int[][] matrix) {
    //     // if(matrix.size)
    //     for(int i = 0; i < matrix.length; i++) {
    //         HashMap<Integer,Integer> map = new HashMap<>();
    //         for(int j = 0; j < matrix[i].length; j++) {
    //             map.put(matrix[i][j],map.getOrDefault(matrix[i][j],0)+1);
    //             if(matrix[i][j] < 1 || matrix[i][j] > matrix.length)
    //                 return false;
    //         }
    //         if(map.size() != matrix.length)
    //             return false;
    //     }
    //     return true;
    // }
    
    public boolean checkValid(int[][] matrix) {
        
        int[][] trans = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                trans[i][j] = matrix[j][i];
            }
        }
        
        for(int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            Arrays.sort(trans[i]);
        }
        
        for(int i = 0; i < matrix.length; i++) {
            int k = 1;
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != k)   return false;
                if(trans[i][j] != k)   return false;
                k++;
            }
        }
        return true;
    }
}