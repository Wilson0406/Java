class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int modulo = 1000000007;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = 1;
        }
        while(k-- > 0) {
            for(int i = 1; i < n; i++) {
                a[i] = (a[i] + a[i - 1]) % modulo;
            }
        }
        return a[n-1] % modulo;
    }
}