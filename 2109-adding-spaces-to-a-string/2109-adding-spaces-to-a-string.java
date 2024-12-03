class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length(), m = spaces.length;
        char[] ans = new char[n + m];
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(j < spaces.length && i == spaces[j]) {
                ans[i + j] += ' ';
                j++;
            }
            ans[i + j] += s.charAt(i);
        }
        return new String(ans);
    }
}