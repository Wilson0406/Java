class Solution {
    public int[] computePatternArray(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for(int i = 1; i < pattern.length;) {
            if(pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                i++;
                index++;
            } else {
                if(index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String original = s;
        String rev = sb.reverse().toString();
        String str = s + "$" + rev;
        
        int lps[] = computePatternArray(str.toCharArray());
        return rev.substring(0, n - lps[2 * n]) + original;
    }
}