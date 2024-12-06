class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0, ans = 0, i = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : banned) {
            set.add(num);
        }
        while(i <= n && sum <= maxSum) {
            if(!set.contains(i) && sum + i <= maxSum) {
                ans++;
                sum += i;
            }
            i++;
        }
        return ans;
    }
}