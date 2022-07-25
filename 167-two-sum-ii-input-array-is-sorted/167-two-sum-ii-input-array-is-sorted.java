class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = {-1,-1};
        int low = 0;
        int high = numbers.length - 1;
        while(numbers[low] + numbers[high] != target) {
            int mid = low + (high - low)/2;
            if(numbers[low] + numbers[high] < target) {
                low++;
            } else if (numbers[low] + numbers[high] > target) {
                high--;
            } 
        }
        res[0] = low+1;
        res[1] = high+1;
        return res;
    }
}