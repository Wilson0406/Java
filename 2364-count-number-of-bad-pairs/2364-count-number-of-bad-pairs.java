class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int key;
        long ans = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            key = i - nums[i];
            if(map.containsKey(key)) {
                ans += (i - map.get(key));
            } else {
                ans += i;
            }
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        return ans;
    }
}