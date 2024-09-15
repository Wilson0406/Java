class Solution {
    public int findTheLongestSubstring(String s) {
        char[] c_m = {1,0,0,0,2,0,0,0,4,0,0,0,0,0,8,0,0,0,0,0,16,0,0,0,0,0};
        int mask = 0, maxLen = 0;
        int []seen = new int[32];
        Arrays.fill(seen, -1);
        for(int i = 0; i < s.length(); i++) {
            mask = mask ^ c_m[s.charAt(i) - 'a'];
            if(mask != 0 && seen[mask] == -1) {
                seen[mask] = i;
            }
            maxLen = Math.max(maxLen, i - seen[mask]);
            //System.out.println(mask);
        }
        return maxLen;
    }
}