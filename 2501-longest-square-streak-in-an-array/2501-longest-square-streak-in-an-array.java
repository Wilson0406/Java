class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int count = -1;
        for(int i = 0; i < n; i++) {
            int ans = (int)Math.sqrt(nums[i]);
            if(ans*ans == nums[i] && map.containsKey(ans)) {
                map.put(nums[i], map.get(ans) + 1);
                if(map.get(ans) + 1 > count) {
                    count = map.get(ans) + 1;
                }
            } else {
                map.put(nums[i],1);
            }
        }
        return count;
    }
}