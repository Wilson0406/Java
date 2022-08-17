class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        //morse code for each alphabet
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        //alphabet string
        String alp = "abcdefghijklmnopqrstuvwxyz";
        //array of alphabets
        char[] alpArr = alp.toCharArray();
        //array containing morse code for all the strings in the array
        String[] ans = new String[words.length];
        
        //map to store  position of each alphabet(a->0, b->1, c->2...)
        HashMap<Character, Integer> letters = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            letters.put(alpArr[i],i);
        }
        
        //map to store count of each morse code in the answer array
        HashMap<String, Integer> map = new HashMap<>();
        
        int j = 0;
        for(String word: words){
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                str.append(morse[letters.get(ch)]);
            }
            ans[j++] = str.toString();
        }
        
        for(String word: ans) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        //return unique morse code
        return map.size();
    }
}