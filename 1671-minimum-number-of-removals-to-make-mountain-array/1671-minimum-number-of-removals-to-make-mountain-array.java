class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        // Longest Increasing Subsequence
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        // Longest Decreasing Subsequence
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
        int ans = n;
        for(int i = 0; i < n; i++) {
            if(LIS[i] > 1 && LDS[i] > 1) {
                ans = Math.min(ans, n - LIS[i] - LDS[i] + 1);
            }
        }
        return ans;
    }
}