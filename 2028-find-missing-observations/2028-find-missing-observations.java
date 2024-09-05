class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];
        int mSum = 0;
        for(int i = 0; i < rolls.length; i++) {
            mSum += rolls[i];
        }
        int i = 0;
        int nSum = (rolls.length + n) * mean - mSum;
        if((nSum > n*6) || (nSum < n*1)) return new int[]{};
        while(nSum > 0) {
            int dice = Math.min(nSum - n + 1, 6);
            ans[i++]= dice;
            nSum -= dice;
            n -= 1;
        }
        return ans;
    }
}