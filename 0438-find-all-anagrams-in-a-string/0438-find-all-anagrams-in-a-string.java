class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || s == null)
            return list;
        int char_count[] = new int[26];
        for(char ch: p.toCharArray()) {
            char_count[ch-'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right < s.length()) {
            if(char_count[s.charAt(right++)-'a']-- >= 1) count--;
            if(count == 0) list.add(left);
            if(right - left == p.length() && char_count[s.charAt(left++)-'a']++ >= 0) count++;
        }
        
        return list;
    }
}