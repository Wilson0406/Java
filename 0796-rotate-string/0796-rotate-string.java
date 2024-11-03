class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            if(sb.toString().equals(goal)) return true;
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            // System.out.println(sb.toString());
        }
        return false;
    }
}