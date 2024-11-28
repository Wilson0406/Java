class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        if(n == 0) return 0;
        long ans = 0;
        
        // Check whitespaces
        while(i < n && s.charAt(i) == ' ') i++;
        
        // Check sign
        int sign = 1;
        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Build Integer
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = 10 * ans + (s.charAt(i) - '0');
            if(sign * ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign*ans);
    }
}