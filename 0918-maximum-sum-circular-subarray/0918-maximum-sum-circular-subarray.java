class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], currMax = 0, minSum = nums[0], currMin = 0;
        for(int x : nums) {
            currMax = Math.max(currMax + x, x);
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin + x, x);
            minSum = Math.min(minSum, currMin);
            total += x;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}