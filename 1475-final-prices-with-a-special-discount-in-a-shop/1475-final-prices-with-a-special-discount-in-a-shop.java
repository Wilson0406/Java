class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = prices[i];
            for(int j = i + 1; j < n; j++) {
                if(ans[i] >= prices[j]) {
                    ans[i] -= prices[j];
                    break;
                } 
            }
        }
        return ans;
    }
}