import java.util.Map.Entry;

class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}