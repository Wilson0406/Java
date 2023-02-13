class Solution {
    public int countOdds(int low, int high) {
        int count = high - low + 1;
        if(low % 2 != 0 && high % 2 != 0){
            return count / 2 + 1;
        } else {
            return count / 2;
        }
    }
}