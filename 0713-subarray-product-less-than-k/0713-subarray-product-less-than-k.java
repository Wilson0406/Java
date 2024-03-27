class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int n = nums.length;
        int result = 0;
        int prod = 1;
        
        int left = 0;
        int right = 0;
        while(right < n) {
            prod *= nums[right];
            
            while(prod >= k) {
                prod /= nums[left];
                left++;
            }
            // includes all the subarrays in the j - i window
            result += right - left + 1;
            right ++;
        }
        return result;
        
    }
}