class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count = -1;
        String[] sen = sentence.split(" ");
        for(int i = 0; i < sen.length; i++) {
            if(sen[i].startsWith(searchWord)) {
                count = i + 1;
                break;
            }
        }
        return count;
    }
}