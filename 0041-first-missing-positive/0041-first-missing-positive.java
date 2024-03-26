class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        if(max <= nums.length) {
            max = nums.length + 1;
        }
        int ans = 0;
        for(int i = 1; i <= max; i++) {
            System.out.println(i);
            if(map.get(i) == null) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}