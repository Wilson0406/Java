class Solution {
    public long minimumSteps(String s) {
        long counter = 0;
        long count = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '1') counter += 1;
            else count += counter;
        }
        return count;
    }
}