class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> str1 = new HashMap<>();
        HashMap<Character, Integer> str2 = new HashMap<>();
        
        if(s == null || t == null || s.length() != t.length()) return false;
        
        for(int i = 0; i < s.length(); i++) {
            
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            int ind1 = str1.getOrDefault(ch1,-1);
            int ind2 = str2.getOrDefault(ch2,-1);
            
            if(ind1 != ind2) {
                return false;
            }
            str1.put(ch1,i);
            str2.put(ch2,i);
        }
        return true;
    }
}