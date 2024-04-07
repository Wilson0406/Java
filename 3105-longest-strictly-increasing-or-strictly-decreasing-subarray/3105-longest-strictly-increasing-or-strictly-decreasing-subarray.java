class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int cur = 0;
        int max = 0;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                cur++;
                max = Math.max(cur,max);
            } else {
                cur = 0;
            }
        }
        max = Math.max(cur,max);
        cur = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                cur++;
                max = Math.max(cur,max);
            } else {
                cur = 0;
            }
        }
        return Math.max(max, cur) + 1;
    }
}