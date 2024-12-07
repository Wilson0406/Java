class Solution {
    public boolean isPossible(int[] nums, int mid, int maxOp) {
        int totalOp = 0;
        for(int num : nums) {
            int op = num / mid;
            if(num % mid == 0) op--;
            
            totalOp += op;
        }
        return totalOp <= maxOp;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1, end = 1;
        for(int num : nums) {
            end = Math.max(end, num);
        }
        
        int ans = end;
        int op = maxOperations;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isPossible(nums, mid, maxOperations)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}