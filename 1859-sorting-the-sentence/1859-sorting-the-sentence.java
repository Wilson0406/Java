class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] ans = new String[arr.length];
        for(String word: arr) {
            sb.append(word);
            StringBuilder sbb = sb.replace(word.length() - 1, word.length(), "");
            char ch = word.charAt(word.length() - 1);
            int a = ch - '0';
            ans[a-1] = sbb.toString();
            sb.setLength(0);
            sbb.setLength(0);
        }
        String res = String.join(" ", ans);
        return res; 
    }
}