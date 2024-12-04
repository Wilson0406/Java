class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n = str1.length(), m = str2.length();
        while(i < n && j < m) {
            
            if(str1.charAt(i) == str2.charAt(j) || str1.charAt(i) + 1 == str2.charAt(j) || (str1.charAt(i) == 'z' && str2.charAt(j) == 'a')) {
                i++;
                j++;
            } else {
                i++;
            }
            if(j == m) return true;
        }
        
        return false;
    }
}