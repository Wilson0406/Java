// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         return nums[n/2];        
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ansIn = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[ansIn]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ansIn = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i< n; i++) {
            if (nums[i] == nums[ansIn]) {
                count++;
            }   
        }
        if (count>n/2) {
            return nums[ansIn];
        }
        return nums[ansIn];
    }
}

