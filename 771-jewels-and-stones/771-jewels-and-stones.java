class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i=0;i<jewels.length();i++) {
            char j = jewels.charAt(i);
            for(char ch: stones.toCharArray()) {
                if(j==ch) {
                    count++;
                }
            }
        }
        return count;
    }
}