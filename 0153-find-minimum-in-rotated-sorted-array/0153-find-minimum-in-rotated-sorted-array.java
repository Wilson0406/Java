// class Solution {
//     public int findMin(int[] nums) {
//         int left = 0;
//         int right = nums.length - 1;
//         if(nums[left] < nums[right]) {
//             return nums[left];
//         }
//         while(left < right) {
//             int mid = left + (right - left)/2;
//             // if nums[mid] < nums[mid-1], element found at nums[mid]
//             if(mid > 0 && nums[mid] < nums[mid-1]) {
//                 return nums[mid];
//             } 
//             // check if left part of array is sorted and right part is not sorted then move to search in the right part
//             else if(nums[mid] > nums[right] && nums[mid] >= nums[left]) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return nums[left];
//     }
// }


class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] < nums[right]) {
            return nums[left];
        }
        while(left + 1 < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
}