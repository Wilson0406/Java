class Solution {
    public boolean findSubarrays(int[] nums) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int j = 1;
        for(int i = 0; i < n-1; i++) {
            sum = nums[i] + nums[j];
            map.put(sum,map.getOrDefault(sum,0)+1);
            j++;
        }
        int count = 0;
        for(int num: map.values()) {
            if(num > 1) {
                count++;
            }
        }
        if(count >= 1) {
            return true;
        }
        return false;
    }
}