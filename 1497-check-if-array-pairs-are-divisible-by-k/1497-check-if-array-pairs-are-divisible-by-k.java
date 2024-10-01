class Solution {
    public boolean canArrange(int[] arr, int k) {
        int freq[] = new int[k];
        int num = 0;
        
        for(int a : arr) {
            a %= k;
            if(a < 0) a += k;
            freq[a]++;
        }
        
        if(freq[0] % 2 != 0) return false;
        for(int i = 1; i <= k / 2; i++) {
            if(freq[i] != freq[k - i]) return false;
        }
        return true;
    }
}