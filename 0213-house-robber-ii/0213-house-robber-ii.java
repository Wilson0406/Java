class Solution {
    public int robHelp(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        
        int rob1 = 0;
        int rob2 = 0;
        for(int i = start; i <= end; i++) {
            int temp = Math.max(rob2, rob1 + nums[i]);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelp(nums, 0, nums.length - 2), robHelp(nums, 1, nums.length - 1));
    }
}