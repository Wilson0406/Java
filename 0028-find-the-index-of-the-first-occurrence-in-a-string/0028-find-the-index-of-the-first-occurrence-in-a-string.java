class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        if(n > h){
            return -1;
        } else if(n == 0) {
            return 0;
        }
        int th = h - n;
        for(int i = 0; i <= th; ++i) {
            if(haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}