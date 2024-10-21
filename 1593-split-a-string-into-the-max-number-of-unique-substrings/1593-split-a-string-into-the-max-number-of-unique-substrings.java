class Solution {
    public void backtrack(int ind, String s, Set<String> ds, int count, int[] max) {
        if(ind >= s.length()) {
            max[0] = Math.max(max[0], count);
            return;
        }
        
        for(int i = ind; i < s.length(); i++) {
            String sub = s.substring(ind, i + 1);
            if(!ds.contains(sub)) {
                ds.add(sub);
                backtrack(i + 1, s, ds, count + 1, max);
                ds.remove(sub);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        int max[] = new int[1], count = 0;
        int ind = 0;
        Set<String> ds = new HashSet<>();
        backtrack(ind, s, ds, count, max);
        return max[0];
    }
}