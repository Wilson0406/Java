class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        int i = 25;
        while(i >= 0) {
            if(count[i] == 0) {
                i--;
                continue;
            }
            
            char ch = (char)('a' + i);
            int freq = Math.min(count[i], repeatLimit);
            
            for(int c = 1; c <= freq; c++) ans.append(ch);
            count[i] -= freq;
            
            // More characters are left
            if(count[i] > 0) {
                int j = i - 1;
                while(j >= 0 && count[j] == 0) j--;
                
                if(j < 0) break;
                ans.append((char)('a' + j));
                count[j]--;
            }
        }
        return ans.toString();
    }
}