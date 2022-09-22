class Solution {
    public String reverseWords(String s) {
        String[] ans = s.split(" ");
        
        int i = 0;
        for(String str : ans) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();
            ans[i++] = sb.toString();
        }
        StringBuilder sbb = new StringBuilder();
        for(String str : ans) {
            sbb.append(str);
            sbb.append(" ");
        }
        sbb.setLength(sbb.length() - 1);
        String res = sbb.toString();
        return res;
    }
}