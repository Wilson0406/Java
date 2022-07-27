class Solution {
    public int pivotIndex(int[] nums) {
        int piv = 0;
        int k = 0;
        int[] lSum = new int[nums.length];
        lSum[0] = nums[0];
        int[] rSum = new int[nums.length];
        rSum[nums.length-1] = nums[nums.length-1];
        for (int i=1;i<nums.length;i++) {
            lSum[i] = nums[i] + lSum[i-1];
            rSum[nums.length-1-i] = nums[nums.length-1-i] + rSum[nums.length-i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(lSum[i] == rSum[i])
                return i;
        }
        return -1;
    }
}