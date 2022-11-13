class Solution {
    public String reverseWords(String s) {
        int i = 0;
        String result = new String();
        int n = s.length();
        while(i < n) {
            while(i < n && s.charAt(i) == ' ') {
                i++;
            }
            if(i >= n) break;
            int j = i + 1;
            while(j < n && s.charAt(j) != ' ') {
                j++;
            }
            String sub = s.substring(i,j);
            if(result.length() == 0) result = sub;
            else result = sub + " " + result;
            i = j + 1;
        }
        return result;
    }
}