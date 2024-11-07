class Solution {
    public int largestCombination(int[] candidates) {
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < candidates.length; i++) {
            StringBuilder sb = new StringBuilder();
            if(Integer.toBinaryString(candidates[i]).length() < 24) {
                int len = Integer.toBinaryString(candidates[i]).length();
                int zero = 24 - len;
                while(zero-- > 0) {
                    sb.append('0');
                }
                
            }
            sb.append(Integer.toBinaryString(candidates[i]));
            map.put(candidates[i], sb.toString());
        }
        
        int ans[] = new int[24];
        int count = 0;
        for(int j = 0; j < 24; j++) {
            for(int i = 0; i < candidates.length; i++) {
                String binary = map.get(candidates[i]);
                ans[j] += binary.charAt(j) - '0';
            }
            count = Math.max(count, ans[j]);
        }
        return count;
    }
}