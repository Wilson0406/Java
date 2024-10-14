class Solution {
    public int rob(int[] nums, int n, int[] dp) {
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max(rob(nums, n - 1, dp), rob(nums, n - 2, dp) + nums[n]);
    }
    public int rob(int[] nums) {
        if(nums.length < 0) return 0;
        int[] dp = new int[nums.length + 1];
        // Arrays.fill(dp, -1);
        
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
        
        // return rob(nums, nums.length - 1, dp);
    }
}