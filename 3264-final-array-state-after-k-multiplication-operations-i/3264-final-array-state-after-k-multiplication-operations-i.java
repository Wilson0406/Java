class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        while(k-- > 0) {
            int min = pq.peek()[1];
            int idx = pq.peek()[0];
            min *= multiplier;
            pq.poll();
            pq.offer(new int[]{idx, min});
        }
        while(!pq.isEmpty()) {
            int min = pq.peek()[1];
            int idx = pq.peek()[0];
            pq.poll();
            ans[idx] = min;
        }
        return ans;
    }
}