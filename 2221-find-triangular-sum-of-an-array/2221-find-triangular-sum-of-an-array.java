class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] temp = new int[n-1];
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] + nums[i+1] > 9){
                temp[i] = (nums[i] + nums[i+1])%10;
            } else {
                temp[i] = nums[i] + nums[i+1];
            }
        }
        return triangularSum(temp);
    }
}