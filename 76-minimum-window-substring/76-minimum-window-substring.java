class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        // frequency map of string t
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        int pcount = t.length();
        
        int i = -1;
        int j = -1;
        // frequency map of string t
        HashMap<Character, Integer> map1 = new HashMap<>();
        while(true) {
            boolean f1 = false;
            boolean f2 = false;
            // first find the substring of s which contains all the characters from string t
            while(i < s.length() - 1 && count < pcount) {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                
                if(map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0))
                    count++;
                f1 = true;
            }
            
            // then reduce the size of the substring by removing characters one by one
            while(j < i && count == pcount) {
                String pans = s.substring(j+1,i+1);
                if(ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }
                j++;
                char ch = s.charAt(j);
                // remove characters from string s from beginning one by one
                if(map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                
                // reduce length of string if count of character appearing in string s is less than the count of characters appearing in t
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0))
                    count--;
                f1 = true;
            }
            if(f1 == false && f2 == false)
                break;
        }
        
        return ans;
    }
}