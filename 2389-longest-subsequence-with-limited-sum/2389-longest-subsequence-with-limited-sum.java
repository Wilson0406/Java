class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int sum = 0;
        int[] ans = new int[queries.length];
        int j = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        for(int i = 0; i < ans.length; i++) {
            ans[i] = sum(nums,queries[i]);
        }
        return ans;
    }
    public static int sum(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == t) return mid+1;
            if(nums[mid] > t) right = mid;
            else
                left = mid + 1;
        }
        return nums[left]<=t? left+1: left;
    }
}