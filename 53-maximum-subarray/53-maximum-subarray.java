class Solution {
    public int maxSubArray(int[] nums) {
        int local = nums[0];
        int global = local;
        for(int i=1;i<nums.length;i++){
            local = Math.max(nums[i],local+nums[i]);
            global = Math.max(local,global);
        }
        return global;
    }
}