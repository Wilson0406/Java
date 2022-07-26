class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > target) {
                right--;
            } else if(nums[mid] < target){
                left++;
            } else {
                return mid;
            }
        }
        return -1;
    }
}