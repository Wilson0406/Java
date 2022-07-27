class Solution {
    public int[] runningSum(int[] nums) {
        int n = 0;
        int len = nums.length;
        int out[] = new int[len];
        for(int i = 0; i < len; i++){
            n += nums[i];
            out[i] = n;
        }
        return out;
    }
}