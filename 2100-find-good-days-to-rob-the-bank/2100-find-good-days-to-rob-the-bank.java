class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> list = new ArrayList<>();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        Arrays.fill(prefix,0);
        Arrays.fill(suffix,0);
        for(int i = 1; i < n; i++) {
            if(security[i] <= security[i-1]) {
                prefix[i] = prefix[i-1]+1;
            }
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if(security[i] <= security[i+1]) {
                suffix[i] = suffix[i+1]+1;
            }
        }
        
        for(int i = time; i < n - time; i++) {
            if(prefix[i] >= time && suffix[i] >= time)
                list.add(i);
        }
        return list;
    }
}