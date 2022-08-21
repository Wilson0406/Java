class Solution {
    public String firstPalindrome(String[] words) {
        String s = "";
        for(String str: words) {
            StringBuilder sb = new StringBuilder(str);
            if(str.equals(sb.reverse().toString())){
                return str;
            }
        }
        return s;
    }
}