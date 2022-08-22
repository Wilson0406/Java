class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        if(n==0)
            return 0;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int val:nums) {
            map.put(val, true);
        }
        for(int val:nums) {
            if(map.containsKey(val-1)) {
                map.put(val, false);
            }
        }
        
        //maximum start point and maximum length
        int msp = 0;
        int ml = 1;
        for(int var: nums) {
            if(map.get(var) == true){
                // local start point and length
                int lsp = var;
                int ll = 1;
                while(map.containsKey(lsp + ll)) {
                    ll++;
                    if(ll>ml) {
                        msp = lsp;
                        ml = ll;
                    }
                }
            }
        }
        return ml;
    }
}