class Solution {
    public int percentageLetter(String s, char letter) {
        // HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int len = s.length();
        int percentage = 0;
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(ch == letter){
                count++;
            }
            // map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // int num = (map.get(letter));
        percentage = (count*100/len);
        return percentage;
    }
}