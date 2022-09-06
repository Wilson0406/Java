// TC - O(n^2)
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//             for(int i=0;i<nums.length;i++)
//                 for(int j=i+1;j<nums.length;j++)
//                     if(nums[i]==nums[j]) return true;
//             return false;
//     }
// }

// TC - O(n)
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for(int i=0;i<nums.length-1;i++)
//             if(nums[i]==nums[i+1]) return true;
//         return false;
//     }
// }

// TC - O(n) SC - O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 1)
                return true;
        }
        
        return false;
    }
}