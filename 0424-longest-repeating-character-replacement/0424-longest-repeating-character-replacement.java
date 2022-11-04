class Solution {

    public int characterReplacement(String s, int k) {
        int[] alp = new int[26];
        int window_start = 0;
        int max_count = 0;
        int max_len = 0;
        for(int window_end = 0; window_end < s.length(); window_end++) {
            alp[s.charAt(window_end) - 'A']++;
            int ch = alp[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, ch);
            
            // window
            while(window_end - window_start - max_count + 1 > k) {
                alp[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_len = Math.max(max_len, window_end - window_start + 1);
            
        }
        return max_len;
    }
}
