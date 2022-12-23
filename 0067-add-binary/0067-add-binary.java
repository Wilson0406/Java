import java.lang.Math;


class Solution {
    public String addBinary(String a, String b) {
        if(a == "0") {
            return b;
        }
        
        if(b == "0") {
            return a;
        }
        
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0) {
            if(i >= 0) carry += a.charAt(i--) - '0';
            if(j >= 0) carry += b.charAt(j--) - '0';
            if(carry == 2) {
                carry = 10;
            }
            if(carry == 3) {
                carry = 11;
            }
            sb.append(carry%10);
            carry /= 10;
        }
        
        return sb.reverse().toString();
    }
}