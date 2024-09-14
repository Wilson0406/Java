class Solution {
    public int longestSubarray(int[] nums) {
        int largest = 1;
        int n = nums.length;
        int max = 0, curr = 0;
        
        // find maximum element of the array bcz that will be the largest AND
        for(int num: nums) {
            max = Math.max(num,max);
        }
        // find the subarray which contains cnotinuous maximum element
        for(int num: nums) {
            if(num == max) {
                largest = Math.max(largest, ++curr);
            } else {
                curr = 0;
            }
        }
        return largest;
    }
}