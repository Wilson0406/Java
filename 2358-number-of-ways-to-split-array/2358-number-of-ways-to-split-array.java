class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        long left = 0, right = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int ans = 0;
        for(int i = 0; i < n - 1; i++) {
            left += nums[i];
            right = sum - left;
            if(left >= right) ans++;
        }
        return ans;
    }
}