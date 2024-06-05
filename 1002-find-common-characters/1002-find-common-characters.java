class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] commonChar = new int[26];
        int[] currentChar = new int[26];
        
        for(char ch: words[0].toCharArray()) {
            commonChar[ch - 'a']++;
        }
        
        for(int i = 1; i < words.length; i++) {
            Arrays.fill(currentChar, 0);
            
            for(char ch: words[i].toCharArray()) {
                currentChar[ch - 'a']++;
            }
            
            for(int letter = 0; letter < 26; letter++) {
                commonChar[letter] = Math.min(currentChar[letter], commonChar[letter]);
            }
        }
        
        for(int letter = 0; letter < 26; letter++) {
            for(int common = 0; common < commonChar[letter]; common++) {
                ans.add(String.valueOf((char)(letter + 'a')));
            }
        }
        return ans;
    }
}