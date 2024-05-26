class Solution {
    public void findSum(int ind, int[] arr, List<List<Integer>> ans, int target, List<Integer> ds) {
        if(ind == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList(ds));
            }
            return;
        }
        
        if(arr[ind] <= target) {
            ds.add(arr[ind]);
            findSum(ind, arr, ans, target - arr[ind], ds);
            ds.remove(ds.size() - 1);
        }
        findSum(ind + 1, arr, ans, target, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findSum(0, candidates, ans, target, new ArrayList());
        return ans;
    }
}