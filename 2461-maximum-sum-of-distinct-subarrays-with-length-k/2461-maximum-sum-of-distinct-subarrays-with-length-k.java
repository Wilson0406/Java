class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, max = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < nums.length) {
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j],0) + 1);
            if(j - i + 1 == k) { // window
                if(map.size() == k) { // condition to check duplicate elements in subarray
                    max = Math.max(max, sum);
                }
                sum -= nums[i]; // remove the 1st element from subarray
                map.put(nums[i], map.get(nums[i]) - 1); // reduce the frequency of 1st element
                if(map.get(nums[i]) == 0) map.remove(nums[i]); // remove the 1st element
                i++;
            }
            j++;
        }
        return max;
    }
}