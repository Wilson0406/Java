class Solution {
    int res = 0;
    public int f(int idx, int or, int max, int nums[], int n) {
        if(or == max) res++;
        
        for(int i = idx; i < n; i++) {
            f(i + 1, or | nums[i], max, nums, n);
        }
        return res;
    }
    public int countMaxOrSubsets(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max |= nums[i];
        }
        return f(0, 0, max, nums, nums.length);
    }
}