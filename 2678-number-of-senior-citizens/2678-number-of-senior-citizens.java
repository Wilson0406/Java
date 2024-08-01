class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String s : details) {
            char []ss = s.toCharArray();
            // if(Integer.parseInt(ss[11])*10 + Integer.parseInt(ss[12]) > 60) {
            if((ss[11] - '0')*10 + (ss[12] - '0') > 60) {
                count++;
            }
        }
        return count;
    }
}