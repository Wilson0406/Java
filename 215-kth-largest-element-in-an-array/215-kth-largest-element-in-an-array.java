class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        // int len = nums.length - k;
        return nums[nums.length - k];
    }
}