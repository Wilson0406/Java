class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] max_right = new int[n];
        int prev_max = 0;
        for(int i = n - 1; i >= 0; i--) {
            max_right[i] = Math.max(nums[i], prev_max);
            prev_max = max_right[i];
        }
        
        int res = 0;
        int left = 0;
        for(int right = 0; right < n; right++) {
            while(nums[left] > max_right[right]) {
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}