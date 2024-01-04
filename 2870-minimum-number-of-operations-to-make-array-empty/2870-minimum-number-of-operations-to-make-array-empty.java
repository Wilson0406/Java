class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            if(n == 1) {
                return -1;
            }
            ans += n / 3;
            if(n % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }
}