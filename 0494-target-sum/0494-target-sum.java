class Solution {
    public int solve(int[] nums, int i, int target, int sum) {
        if(i == nums.length) {
            if(sum == target) return 1;
            else return 0;
        }
        
        int plus = solve(nums, i + 1, target, sum + nums[i]);
        int minus = solve(nums, i + 1, target, sum - nums[i]);
        
        return plus + minus;
    }
    public int find(int i, int[] nums, int target, int[][] dp) {
        if(i == 0) {
            if(target == 0 && nums[i] == 0) return 2;
            if(target == 0 || target == nums[i]) return 1;
            return 0;
        }

        if(dp[i][target] != -1) return dp[i][target];

        int notTaken = find(i - 1, nums, target, dp);
        int taken = 0;
        if(target >= nums[i]) {
            taken = find(i - 1, nums, target - nums[i], dp);
        }
        return dp[i][target] = taken + notTaken;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int n : nums) total += n;
        if(total - target < 0 || (total - target) % 2 == 1) return 0;
        int[][] dp = new int[nums.length][((total - target) / 2) + 1];
        for(int[] r: dp) Arrays.fill(r, -1);
        return find(nums.length - 1, nums, (total - target) / 2, dp);
        // return solve(nums, 0, target, 0);
    }
}