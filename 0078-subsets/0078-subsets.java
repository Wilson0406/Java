class Solution {
    public void subset(int ind, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        
        for(int i = ind; i < nums.length; i++) {
            ds.add(nums[i]);
            subset(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subset(0, nums,new ArrayList<>(), ans);
        return ans;
    }
}