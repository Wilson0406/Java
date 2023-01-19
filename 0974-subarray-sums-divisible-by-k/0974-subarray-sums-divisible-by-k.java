class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int map[] = new int[k];
        map[0] = 1;
        int count = 0, sum = 0;
        for(int x : nums) {
            sum = (sum + x) % k;
            if(sum < 0) sum += k;
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}