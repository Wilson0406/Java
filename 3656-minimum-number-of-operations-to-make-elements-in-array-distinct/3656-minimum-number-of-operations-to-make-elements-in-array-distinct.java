class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] map = new int[101];
        for(int i = n - 1; i >= 0; i--) {
            map[nums[i]]++;
            if(map[nums[i]] > 1) return i / 3 + 1;
        }
        return 0;
    }
}