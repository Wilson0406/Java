class Solution {
    public long countSubarrays(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        for(int n : nums) {
            if(n > max) {
                max = n;
            }
        }
        long ans = 0;
        long n = nums.length;
        long j = 0;
        long i = 0;
        long count = 0;
        while(j < n) {
            if(nums[(int)j] == max) {
                count++;
            }
            // System.out.println(ans);
            while(count >= k) {
                if(nums[(int)i] == max) {
                    count--;
                }
                i++;
                ans += n - j;
            }
            j++;
        }
        return ans;
    }
}