class Solution {
    // Bubble sort with one more condition
    public boolean canSortArray(int[] nums) {
        boolean swapped = true;
        for(int i = 0; i < nums.length; i++) {
            swapped = false;
            for(int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] <= nums[j + 1]) continue;
                else {
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        swapped = true;
                    }
                    else {
                        return false;
                    }
                }
            }
            // Already sorted
            if(swapped == false) {
                break;
            }
        }
        return true;
    }
}