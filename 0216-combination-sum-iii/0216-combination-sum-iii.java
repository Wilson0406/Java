class Solution {
    public void findSum(int ind, int k, List<List<Integer>> ans, int target, List<Integer> ds) {
        if(ds.size() == k) {
            if(target == 0) {
                ans.add(new ArrayList(ds));
                return;
            }
        }
        
        for(int i = ind; i < 10; i++) {
            if(i > target) break;
            
            ds.add(i);
            findSum(i + 1, k, ans, target - i, ds);
            ds.remove(ds.size() - 1);
        }
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findSum(1, k, ans, n, new ArrayList<>());
        return ans;
    }
}