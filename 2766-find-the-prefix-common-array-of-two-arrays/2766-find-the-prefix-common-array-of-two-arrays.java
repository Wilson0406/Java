class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[51];
        int[] C = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            freq[A[i]]++;
            freq[B[i]]++;
            C[i] = 0;
            for(int j = 0; j < 51; j++) if(freq[j] > 1) C[i]++;
        }
        return C;
    }
}