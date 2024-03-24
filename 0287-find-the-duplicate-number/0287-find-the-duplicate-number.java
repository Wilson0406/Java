// import java.util.Map.Entry;

// class Solution {
//     public int findDuplicate(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//         }
//         for(Entry<Integer,Integer> entry : map.entrySet()) {
//             if(entry.getValue() > 1) {
//                 return entry.getKey();
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }
        int slow2 = 0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) {
                return slow;
            }
        }

    }
}