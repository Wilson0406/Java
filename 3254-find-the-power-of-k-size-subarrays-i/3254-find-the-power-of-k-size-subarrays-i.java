class Solution {
    public boolean consecutiveSorted(int[] nums, int i, int j) {
        for(int k = i; k < j; k++) {
            if(nums[k] != nums[k + 1] - 1) {
                return false;
            }
        }
        return true;
    }
    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int p = 0;
        for(int i = 0; i <= nums.length - k; i++) {
            if(consecutiveSorted(nums, i, k + i - 1)) {
                res[p++] = nums[k + i - 1];
            } else {
                res[p++] = -1;
            }
        }
        return res;
    }
}