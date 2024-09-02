class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int totalChalk = 0;
        for(int i = 0; i < chalk.length; i++) {
            totalChalk += chalk[i];
            k -= chalk[i];
            if(k < 0) return i;
        }
        System.out.println(totalChalk);
        k %= totalChalk;
        System.out.println(k);
        int ans = 0;
        for(int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if(k < 0) {
                return i;
            }
        }
        return ans;
    }
}