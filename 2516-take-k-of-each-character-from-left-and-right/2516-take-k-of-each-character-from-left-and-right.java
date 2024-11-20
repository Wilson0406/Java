class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int a = 0, b = 0, c = 0; // Deletion counts
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') a++;
            else if(s.charAt(i) == 'b') b++;
            else c++;
        }
        if(a < k || b < k || c < k) return -1;
        
        int notDeletedWindowSize = 0;
        int i = 0, j = 0;
        while(j < n) {
            if(s.charAt(j) == 'a') a--;
            else if(s.charAt(j) == 'b') b--;
            else c--;
            
            // Shrink the window if any character count becomes less than k
            while(i <= j && (a < k || b < k || c < k)) {
                if(s.charAt(i) == 'a') a++;
                else if(s.charAt(i) == 'b') b++;
                else c++;
                i++;
            }
            notDeletedWindowSize = Math.max(notDeletedWindowSize, j - i + 1);
            j++;
        }
        return n - notDeletedWindowSize;
    }
}