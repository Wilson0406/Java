class Solution {
    public String intToRoman(int num) {
        int[] codeInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < code.length; i++) {
            while(num >= codeInt[i]) {
                sb.append(code[i]);
                num -= codeInt[i];
            }
        }
        return sb.toString();
    }
}