// class Solution {
//     public int minimumAverageDifference(int[] nums) {
//         long min = Integer.MAX_VALUE;
//         int sum1 = 0;
//         int sum2 = 0;
//         int n = nums.length;
//         int res = 0;
        
//         for(int i = 0; i < n; i++) {
//             sum2 += nums[i];
//         }
        
//         for(int i = 0; i < n; i++) {
//             sum1 += nums[i];
//             sum2 -= nums[i];
//             long abs = Math.abs(sum1/(i+1) - (i == n - 1 ? 0 : sum2/(n-i-1)));
//             if(abs < min) {
//                 min = abs;
//                 res = i;
//             }
//         }
        
//         return res;
//     }
// }



// // nums = [2,5,3,9,5,3]
// // prefix = [2,7,10,19,24,27]
// // [0,2,7,10,19,24]
// // suffix = [25,20,17,8,3,0]










class Solution {
    public int minimumAverageDifference(int[] nums) {
        int len = nums.length, res = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < len; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len -i - 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}