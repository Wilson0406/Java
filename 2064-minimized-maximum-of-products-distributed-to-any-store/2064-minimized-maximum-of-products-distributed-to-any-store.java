class Solution {
    public boolean canDistribute(int shops, int[] quantities, int x) {
        for(int product : quantities) {
            shops -= (product + x - 1) / x; // Ceil value
            if(shops < 0) return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int r = 0;
        for(int q : quantities) {
            r = Math.max(q, r);
        }
        int l = 1;
        int ans = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(canDistribute(n, quantities, mid)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}