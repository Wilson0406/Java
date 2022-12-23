class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if(prices == null || n <= 1) {
            return 0;
        }
        
        
        int b0 = -prices[0], b1 = b0, b2 = 0, s0 = 0, s1 = 0, s2 = 0;
        
        for(int i = 1; i < n; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}