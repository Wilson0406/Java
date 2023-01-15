class Solution {
    public int differenceOfSum(int[] nums) {
        int element = 0;
        int digit = 0;
        for(int num : nums) {
            element += num;
            while(num > 0) {
                digit += num % 10;
                num /= 10;
            }
        }
        return Math.abs(element - digit);
    }
}