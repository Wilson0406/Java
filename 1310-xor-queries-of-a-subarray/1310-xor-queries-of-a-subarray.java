class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length];
        int k = 0;
        xor[0] = arr[0] ^ k;
        int ans[] = new int[queries.length];
        for(int i = 1; i < arr.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
            System.out.println(xor[i]);
        }
        int i = 0;
        for(int []query : queries) {
            int start = query[0];
            int end = query[1];
            if(start == 0) ans[i++] = xor[end];
            else ans[i++] = xor[end] ^ xor[start - 1];
            
        }
        return ans;
    }
}