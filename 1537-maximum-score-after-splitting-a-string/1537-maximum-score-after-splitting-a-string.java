class Solution {
    public int maxScore(String s) {
        int max = 0, zero = 0, one = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') one++;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0') zero++;
            else {
                if(one >= 1) one--;
            }
            max = Math.max(max, zero + one);
        }
        return max;
    }
}