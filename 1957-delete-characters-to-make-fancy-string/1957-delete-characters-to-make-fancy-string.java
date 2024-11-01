class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == sb.charAt(sb.length() - 1)) {
                count++;
                if(count < 3) {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
                count = 1;
            }
            
            
        }
        return sb.toString();
    }
}