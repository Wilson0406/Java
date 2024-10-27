class Solution {
    int memo[] = new int[100001];
    long MOD = 1000000007;
    
    public int compute(int t) {
        if(memo[t] != -1) return memo[t];
        String s = "ab";
        long count = 0;
        for(int i = 0; i < 2; i++) {
            int x = s.charAt(i) - 'a';
            if(x + t > 25) {
                int rem = t - (26 - x);
                count = (count + compute(rem) + 1) % MOD;
            }
        }
        return memo[t] = (int)count;
    }
    public int lengthAfterTransformations(String s, int t) {
        Arrays.fill(memo, -1);
        long res = s.length();
        for(int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if(x + t > 25) {
                int rem = t - (26 - x);
                res = (res + compute(rem) + 1) % MOD;
            }
        }
        
        return (int)res;
    }
}