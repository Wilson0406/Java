// Time -> O(N), Space -> O(N)
// class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int len = nums.length;
//         int[] ch = new int[len];
//         int[] ans = new int[2];
        
//         for(int i: nums) {
//             ch[i-1]++;
//         }
//         for(int i = 0; i < len; i++) {
//             if(ch[i] == 2) {
//                 ans[0] = i + 1;
//             }
//             if(ch[i] == 0) {
//                 ans[1] = i + 1;
//             } 
//         }
//         return ans;
//     }
// }

// Time -> O(N), Space -> O(1)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2];
        
        for(int i: nums) {
            if(nums[Math.abs(i)-1] < 0) {
                ans[0] = Math.abs(i);
            } else {
                nums[Math.abs(i)-1] *= -1;
            }
        }
        for(int i = 0; i < len; i++) {
             if(nums[i] > 0) {
                 ans[1] = i + 1;
             }
        }
        return ans;
    }
}