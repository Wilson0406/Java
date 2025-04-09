class Solution {
    public int minOperations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int[] count = new int[101];
        for(int i = 0; i < n; i++) {
            count[nums[i]]++;
            min = Math.min(nums[i], min);
        }
        if(min < k) return -1;
        int ans = 0;
        for(int i = 0; i < 101; i++) {
            if(count[i] > 0 && i > k) ans++;
        }

        return ans;
    }
}