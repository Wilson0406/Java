class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0;
        int res = 0;
        int n = nums.length;
        while(i < n) {
            while(j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }
            res = Math.max(res, j - i);
            i++;
        }
        return res;
    }
}