class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        if(s.length() == 1) return 1;
        HashSet<Character> map = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.contains(ch)){
                map.remove(ch);
                count++;
            } else {
                map.add(ch);
            }
        }
        if(!map.isEmpty()) return count*2+1;
        return count*2;
    }
}