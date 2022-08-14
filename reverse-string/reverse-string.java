class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        solve(s,i,j);
    }
    public void solve(char[] s, int i, int j) {
        if(i >= j)
            return;
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
        solve(s,++i,--j);        
    }
}