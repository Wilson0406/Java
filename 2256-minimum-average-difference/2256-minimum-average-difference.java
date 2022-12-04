class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum1 = 0, sum2 = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        for(int i = 0; i < n; i++) {
            sum1 += nums[i];
            sum2 = sum - sum1;
            long abs = Math.abs(sum1/(i+1) - (n - i == 1 ? 0 : sum2/(n-i-1)));
            if(abs < min) {
                min = abs;
                res = i;
            }
        }
        
        return res;
    }
}

// nums = [2,5,3,9,5,3]
// prefix = [2,7,10,19,24,27]
// [0,2,7,10,19,24]
// suffix = [25,20,17,8,3,0]
