// "MuFoevIXCZzrpXeRmTssj lYSW U jM"
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        if(words.length == 1) return words[0].charAt(0) == words[0].charAt(words[0].length() - 1);
        String prev = words[0];
        for(int i = 1; i < words.length; i++) {
            if(words[i].charAt(0) != prev.charAt(prev.length() - 1)) return false;
            prev = words[i];
        }
        return words[0].charAt(0) == words[words.length - 1].charAt(words[words.length - 1].length() - 1);
    }
}