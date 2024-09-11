class Solution {
    public String decToBin(int n) {
        String ans = "";
        for(int i = 31; i >= 0; i--) {
            int k = n >> i;
            if((k & 1) > 0) {
                ans += "1";
            } else {
                ans += "0";
            }
        }
        return ans;
    }
    public int minBitFlips(int start, int goal) {
        String st = decToBin(start);
        String go = decToBin(goal);
        int count = 0;
        for(int i = 0; i < 32; i++) {
            int a = (st.charAt(i) - '0') ^ (go.charAt(i) - '0');
            if(a == 1) count++;
        }
        return count;
    }
}