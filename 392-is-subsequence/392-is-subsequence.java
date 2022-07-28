class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;
        int count = 0;
        for (int i = 0; i < t.length() && count< s.length(); i++) {
            if(t.charAt(i) == s.charAt(count)) {
                count++;
            }
        }
        return count == s.length();
    }
}