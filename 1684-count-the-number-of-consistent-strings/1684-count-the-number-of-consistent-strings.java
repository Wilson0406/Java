class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(String word: words) {
            int len = 0;
            for(int i = 0; i < word.length(); i++) {
                if((allowed.indexOf(word.charAt(i))) == -1) break;
                else len++;
                if(len == word.length()) count++;
            }
        }
        return count;
    }
}