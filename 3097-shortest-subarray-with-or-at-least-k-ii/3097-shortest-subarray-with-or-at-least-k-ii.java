class Solution {
    public void updateBits(int num, int[] bits, int val) {
        for(int i = 0; i < 32; i++) {
            if(((num >> i) & 1) != 0) { // check if ith bit is set
                bits[i] += val;
            }
        }
    }
    public int getDecimalFromBinary(int[] bits) {
        int num = 0;
        for(int i = 0; i < 32; i++) {
            if(bits[i] > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int[] bits = new int[32];
        int i = 0, j = 0;
        
        while(j < n) {
            updateBits(nums[j], bits, 1);
            
            while(i <= j && getDecimalFromBinary(bits) >= k) {
                updateBits(nums[i], bits, -1);
                result = Math.min(result, j - i + 1);
                i++;
            }
            j++;
        }
        return result ==  Integer.MAX_VALUE ? -1 : result;
    }
}