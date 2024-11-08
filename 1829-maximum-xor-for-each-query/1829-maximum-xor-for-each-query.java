class Solution {
    // Brute Force
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxK = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i] ^ prefix[i - 1];
        }
        int j = 0;
        for(int i = n - 1; i >= 0; i--) {
            ans[j++] = (prefix[i] ^ maxK);
        }
        return ans;
    }
}