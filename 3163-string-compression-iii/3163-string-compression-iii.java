class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();
        while(!word.isEmpty()) {
            char c = word.charAt(0);
            int count = 1;
            while(count < 9 && count < word.length() && word.charAt(count) == c) {
                count++;
            }
            str.append(count).append(c);
            word = word.substring(count);
        }
        return str.toString();
    }
}