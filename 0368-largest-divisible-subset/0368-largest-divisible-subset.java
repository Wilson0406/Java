class Solution {
    // public 
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i = 0; i < n; i++) hash[i] = i;

        Arrays.fill(dp, 1);
        int last = 0, max = 1;
        for(int i = 0; i < n; i++) {
            hash[i] = i;
            for(int p = 0; p < i; p++) {
                if(nums[i] % nums[p] == 0 && dp[i] < 1 + dp[p]) {
                    dp[i] = 1 + dp[p];
                    hash[i] = p;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                last = i;
            }
        }
        ans.add(nums[last]);
        while(hash[last] != last) {
            last = hash[last];
            ans.add(nums[last]);
        }
        
        return ans;
    }
}