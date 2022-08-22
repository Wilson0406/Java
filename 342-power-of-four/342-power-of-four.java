class Solution {
    public boolean isPowerOfFour(int n) {
        double check = Math.log(n)/Math.log(4);
        return check == (int)check;
    }
}