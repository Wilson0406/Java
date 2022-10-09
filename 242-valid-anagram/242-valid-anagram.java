class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        if(s.length() == 1 && t.length() == 1){
            if(s == t){
                return true;
            }
        }
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch) - 1);
            } else {
                return false;
            }
        }
        for(int i = 0; i < map.size(); i++) {
            if(map.get(t.charAt(i)) != 0) {
                return false;
            }
        }
        return true;
    }
}