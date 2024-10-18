class Solution {
    int res = 0;
    public int f(int idx, int or, int max, int nums[], int n) {
        if(idx == n) {
            if(or == max) return 1;
            return 0;            
        }
        
        int take = f(idx + 1, or | nums[idx], max, nums, n);
        int notTake = f(idx + 1, or, max, nums, n);
        
        return take + notTake;
    }
    public int countMaxOrSubsets(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max |= nums[i];
        }
        return f(0, 0, max, nums, nums.length);
    }
}