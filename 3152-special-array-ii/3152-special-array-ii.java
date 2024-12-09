class Solution {
    public boolean isSpecial(int[] nums, int query[], int[] violating) {
        if(violating[query[1]] - violating[query[0]] != 0) return false;
        return true;
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean ans[] = new boolean[queries.length];
        int n = nums.length;
        int[] violating = new int[n];
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] % 2 == nums[i] % 2) {
                violating[i] = violating[i - 1] + 1;
            } else {
                violating[i] = violating[i - 1];
            }
        }
        for(int i = 0; i < queries.length; i++) {
            ans[i] = isSpecial(nums, queries[i], violating);
        }
        return ans;
    }
}