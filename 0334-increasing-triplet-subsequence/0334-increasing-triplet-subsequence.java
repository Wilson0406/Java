class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            // 1st value will be stored
            if(nums[i] <= small) {
                small = nums[i];
            }
            // 2nd value greater than small will be stored
            else if(nums[i] <= big) {
                big = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}