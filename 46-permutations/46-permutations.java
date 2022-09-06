class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        permute(nums,out,0);
        return out;
    }
    public void permute(int[] nums, List<List<Integer>> ans, int start) {
        List<Integer> res = new ArrayList<>();
        int temp;
        if(start == nums.length)
            ans.add(toList(nums));
        for(int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, ans, start + 1);
            swap(nums, i, start);
        }
        
    }
    
    public List<Integer> toList(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int n:arr){
            res.add(n);
        }
        return res;
    }
    
    int[] swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        return nums;
    }
}