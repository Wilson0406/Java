class Solution {
    public String invert(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '0') sb.setCharAt(i, '1');
            else if(sb.charAt(i) == '1') sb.setCharAt(i, '0');
        }
        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        if(n == 1 && k == 1) return '0';
        String[] str = new String[n];
        str[0] = "0";
        for(int i = 1; i < n; i++) {
            str[i] = str[i - 1] + '1' + invert(str[i - 1]);
        }
        char c = '0';
        for(int i = 0; i < str[n - 1].length(); i++) {
            if(k - 1 == i) c = str[n - 1].charAt(i);
        }
        return c;
    }
}