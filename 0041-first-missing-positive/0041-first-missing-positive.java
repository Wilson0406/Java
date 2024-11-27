// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Map<Integer,Integer> map = new HashMap<>();
//         int max = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
//             if(nums[i] > max) {
//                 max = nums[i];
//             }
//         }
//         if(max <= nums.length) {
//             max = nums.length + 1;
//         }
//         int ans = 0;
//         for(int i = 1; i <= max; i++) {
//             if(map.get(i) == null) {
//                 ans = i;
//                 break;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
//         boolean one = false;
//         for(int x : nums)
//             if(x == 1)
//                 one = true;
//         if(!one)
//             return 1;
//         if(n == 1) return 2;
        
//         for(int i = 0; i < n; i++) {
//             if(nums[i] <= 0 || nums[i] > n) {
//                 nums[i] = 1;
//             }
//         }
        
//         for(int i = 0; i < n; i++) {
//             int x = Math.abs(nums[i]) - 1;
//             System.out.println(x);
//             if(nums[x] > 0) {
//                 nums[x] *= -1;
//             }
            
//         }
        
//         for(int i = 0; i < n; i++) {
//             if(nums[i] > 0) {
//                 return i + 1;
//             }
//         }
        // Place numbers at correct index(1 at 0, 2 at 1, so on)
        for(int i = 0; i < n; i++) {
            int currIdx = nums[i] - 1;
            while(currIdx >= 0 && currIdx <= n - 1 && nums[i] != nums[currIdx]) {
                int temp = nums[i];
                nums[i] = nums[currIdx];
                nums[currIdx] = temp;
                currIdx = nums[i] - 1;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(i != nums[i - 1]) return i;
        }
        
        // If all elements are present, then return length of array + 1
        return n + 1;
    }
}