class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] lSum = new int[nums.length];
        lSum[0] = nums[0];
        
        int[] rSum = new int[nums.length];
        rSum[nums.length-1] = nums[nums.length-1];
        
        for (int i=1;i<nums.length;i++) {
            // Prefix sum from left side
            lSum[i] = nums[i] + lSum[i-1];
            // Prefix sum from right side
            rSum[nums.length-1-i] = nums[nums.length-1-i] + rSum[nums.length-i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            if(lSum[i] == rSum[i])
                return i;
        }
        return -1;
    }
}