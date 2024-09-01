class Solution {
    public int sum(String s) {
        char ch1 = s.charAt(0);
        int a = ch1;
        char ch2 = s.charAt(1);
        int b = ch2;
        return a + b; 
    }
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        boolean isEven = false;
        boolean isOdd = false;
        if(sum(coordinate1) % 2 == 0 && sum(coordinate2) % 2 == 0) {
            isEven = true;
        } else if(sum(coordinate1) % 2 != 0 && sum(coordinate2) % 2 != 0) {
            isOdd = true;
        }
        if(isEven || isOdd) return true;
        return false;
    }
}