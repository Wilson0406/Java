class Solution {
//     public int binarySearch(int array[], int target, int low, int high) {
//         while(low<=high) {
//             int mid = low + (high - low)/2;
            
//             if(array[mid] == target) {
//                 return mid;
//             }
//             if(array[mid] < target) {
//                 low = mid + 1;
//             }
//             else {
//                 high = mid - 1;
//             }
//         }
//         return -1;
//     }
    
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1, -1};
        int low = 0;
        int size = nums.length;
        int high = size - 1;
        
        if(size == 0) {
            return ans;
        }
        // Since the array is sorted
        while (nums[low] < nums[high]) {
            int mid = low + (high - low)/2;
            if(nums[mid] > target) {
                high = mid - 1;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                if(nums[low] == nums[mid]) {
                    high--;
                }
                else {
                    low++;
                }
            }
        }
        if(nums[low] == nums[high] && nums[low] == target) {
            ans[0] = low;
            ans[1] = high;
        }
        return ans;
    }
}