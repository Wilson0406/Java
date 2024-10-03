class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum = (sum + num) % p;
        }
        int target = sum % p;
        if(target == 0) return 0;
        // Sum % p, index
        Map<Integer, Integer> map = new HashMap<>();
        int res = n;
        map.put(0, -1);
        int curr = 0;
        for(int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int prev = (curr - target + p) % p;
            if(map.containsKey(prev)) {
                res = Math.min(res, i - map.get(prev));
            }
            map.put(curr, i);
        }
        return res == n ? -1 : res;
    }
}