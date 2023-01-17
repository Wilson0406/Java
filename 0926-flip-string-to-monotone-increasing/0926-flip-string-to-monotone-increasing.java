class Solution {
    public int minFlipsMonoIncr(String s) {
        if(s == null || s.length() <= 0) return 0;
        
        int flip = 0, one = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(one == 0) continue;
                else flip++;
            } else {
                one++;
            }
            
            if(flip > one) {
                flip = one;
            }
        }
        return flip;
    }
}