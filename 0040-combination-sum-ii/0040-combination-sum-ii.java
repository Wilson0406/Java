class Solution {
    public void findSum(int ind, int[] arr, List<List<Integer>> ans, int target, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i = ind; i < arr.length; i++) {
            // Dont take duplicate values
            if(i > ind && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;
            
            ds.add(arr[i]);
            findSum(i + 1, arr, ans, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(0, candidates, ans, target, new ArrayList<>());
        return ans;
    }
}