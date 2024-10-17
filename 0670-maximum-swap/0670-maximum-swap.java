class Solution {
    public int maximumSwap(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        int[] maxRight = new int[n];
        maxRight[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            int maxIdx = maxRight[i + 1];
            int max = s[maxIdx];
            maxRight[i] = s[i] > max ? i : maxIdx;
        }
        
        for(int i = 0; i < n; i++) {
            if(s[i] < s[maxRight[i]]) {
                char temp = s[i];
                s[i] = s[maxRight[i]];
                s[maxRight[i]] = temp;
                return Integer.parseInt(String.valueOf(s));
            }
        }
        
        return num;
    }
}