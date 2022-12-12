class Solution {
    public int appendCharacters(String s, String t) {
        int s1 = 0;
        int t1 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(s1) == t.charAt(t1)) {
                s1++;
                t1++;
            } else {
                s1++;
            }
            if(t1 == t.length()) {
                break;
            }
        }
        return t.length() - t1;
    }
}