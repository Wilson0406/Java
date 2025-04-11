class Solution {
    public boolean check(String s) {
        int len = s.length();
        if(len % 2 == 1) return false;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < len / 2; i++) {
            sum1 += s.charAt(i);
        }

        for(int i = len / 2; i < len; i++) {
            sum2 += s.charAt(i);
        }
        return sum1 == sum2;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++) {
            if(check(Integer.toString(i)) == true) {
                count++;
            }
        }
        return count;
    }
}