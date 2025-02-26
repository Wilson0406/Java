class Solution {
    public boolean solve(int i, int target, int[] nums, int[][]dp) {
        if(target == 0) return true;
        if(i == 0) return nums[i] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1 ? true : false;

        boolean notTake = solve(i - 1, target, nums, dp);
        boolean take = false;
        if(target >= nums[i]) {
            take = solve(i - 1, target - nums[i], nums, dp);
        }

        boolean res = take || notTake;
        dp[i][target] = res ? 1 : 0;
        return res;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int a : nums) {
            sum += a;
        }
        int target = sum / 2;
        if(sum % 2 == 1) return false;
        int[][] dp = new int[n + 1][target + 1];
        for(int row[]: dp) Arrays.fill(row, -1);
        return solve(n - 1, target, nums, dp);
    }
}