class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        //to keep track of negative numbers
        int min = nums[0];
        
        int result = nums[0];
        
        if(nums.length == 0) return 0;
        
        for(int i = 1; i < nums.length; i++) {
            int temp = Math.max(max*nums[i],Math.max(nums[i], min*nums[i]));
            min = Math.min(max*nums[i],Math.min(nums[i], min*nums[i]));
            
            max = temp;
            result = Math.max(result,max);
        }
        return result;
    }
}