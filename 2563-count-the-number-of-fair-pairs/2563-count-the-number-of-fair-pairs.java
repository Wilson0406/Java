class Solution {
    public int lowerBound(int[] nums, int start, int end, int target) {
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    public int upperBound(int[] nums, int start, int end, int target) {
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums); // 0 <= i < j < n -> This doesn't matter as we are checking the sum of pairs
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int leftIdx = lowerBound(nums, i + 1, n, lower - nums[i]);
            int rightIdx = upperBound(nums, i + 1, n, upper - nums[i]);
            
            int x = leftIdx - i - 1;
            int y = rightIdx - i - 1;
            
            ans += (y - x);
        }
        return ans;
    }
}