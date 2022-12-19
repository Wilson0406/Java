class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        int n = nums[0];
        left[0] = 1;
        int m = nums[nums.length-1];
        right[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++) {
            left[i] = n;
            n *= nums[i];
        }
        
        for(int i = nums.length-2; i >= 0; i--) {
            right[i] = m;
            m *= nums[i];
        }
        
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = left[i]*right[i];
        }
        
        return arr;
    }
}