class Solution {
    // TC: O(nlogn)
    // public int longestSquareStreak(int[] nums) {
    //     Arrays.sort(nums);
    //     int max = 0;
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int num : nums) {
    //         int root = (int)Math.sqrt(num);
    //         if(root * root == num && map.containsKey(root)) {
    //             map.put(num, map.get(root) + 1);
    //         } else {
    //             map.put(num, 1);
    //         }
    //         max = Math.max(max, map.get(num));
    //     }
    //     // System.out.println(max);
    //     return max == 1 ? -1 : max;
    // }
    
    // TC: O(N)
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums) {
            set.add(num);
        }
        for(int i = 0; i < nums.length; i++) {
            long curr = nums[i];
            int streak = 0;
            while(set.contains((int)curr)) {
                streak++;
                if(curr * curr > 100000) {
                    break;
                }
                curr *= curr;
            }
            ans = Math.max(ans, streak);
        }
        return ans < 2 ? -1 : ans;
    }
}