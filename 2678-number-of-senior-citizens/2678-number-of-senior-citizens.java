class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String s : details) {
            char []ss = s.toCharArray();
            if((ss[11] - '0')*10 + (ss[12] - '0') > 60) {
                count++;
            }
        }
        return count;
    }
}