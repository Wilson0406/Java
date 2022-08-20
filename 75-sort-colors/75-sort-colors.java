class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int c0 = 0;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0)
                ans[c0++] = 0;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1)
                ans[c0++] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] == 2)
                ans[c0++] = 2;
        }
        
        for(int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }
}