class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int sum = 0;
            if(k > 0) {
                for(int j = i + 1; j <= k + i; j++) {
                    sum += code[j % n];
                }
            } else if(k < 0) {
                for(int j = i - Math.abs(k); j < i; j++) {
                    sum += code[(j + n) % n];
                }
            } else {
                sum = 0;
            }
            ans[i] = sum;
        }
        return ans;
    }
}