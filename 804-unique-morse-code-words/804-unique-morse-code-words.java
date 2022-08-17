class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String alp = "abcdefghijklmnopqrstuvwxyz";
        char[] alpArr = alp.toCharArray();
        String[] ans = new String[words.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Character, Integer> letters = new HashMap<>();
        
        for(int i = 0; i < 26; i++) {
            letters.put(alpArr[i],i);
        }
        int j = 0;
        for(String word: words){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                str.append(morse[letters.get(ch)]);
            }
            ans[j] = str.toString();
            j++;
        }
        
        int count = 0;
        
        for(String word: ans) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        count = map.size();
        return count;
    }
}