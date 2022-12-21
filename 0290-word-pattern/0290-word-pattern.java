class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] pat = s.split(" ");
        char[] str = pattern.toCharArray();
        
        HashMap<Character, String> map = new HashMap<>();
        
        if(str.length != pat.length) {
            return false;
        }
        int i = 0;
        for(char ch: str) {
            if(map.containsKey(ch)) {
                if(!map.get(ch).equals(pat[i]))
                    return false;
            } else {
                if(map.containsValue(pat[i]))
                    return false;
                map.put(ch, pat[i]);
            }
            i++;
        }
        
        return true;
    }
}