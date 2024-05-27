class Solution {
    public void combination(int start, int n, int k, List<List<Integer>> ans, List<Integer> ds) {
        if(ds.size() == k) {
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i = start; i <= n; i++) {
            ds.add(i);
            combination(i + 1, n, k, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(1, n, k, ans, new ArrayList());
        return ans;
    }
}