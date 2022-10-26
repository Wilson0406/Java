class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        // store remainder of prefix sum with index value in map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int rem = 0;
        for(int i = 0; i < len; i++) {
            rem += nums[i];
            if(k != 0) rem %= k;
            // if same remainder comes again and the number of elements is greater than or equal to 2 then return true
            if(map.containsKey(rem)) {
                if(i - map.get(rem) > 1)
                    return true;
            } else {
                map.put(rem,i);
            }
        }
        return false;
    }
}