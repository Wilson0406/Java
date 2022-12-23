class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        // int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                // int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i+j] += res[i+j+1]/10;
                res[i+j+1] %= 10;
            }
        }
        for(int n : res) {
            if(!(sb.length() == 0 && n == 0)) {
                sb.append(n);
            }
        }
        return sb.toString();
    }
}

// 43210

//   123
//   456
// -------
//   738
//  615x
// 492xx
// -------
// 56088