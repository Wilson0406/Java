class Solution {
    public int count(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
        }
        return count;
    }
    public boolean halvesAreAlike(String s) {
        return count(s.substring(0,s.length()/2)) == count(s.substring(s.length()/2, s.length()));
    }
}