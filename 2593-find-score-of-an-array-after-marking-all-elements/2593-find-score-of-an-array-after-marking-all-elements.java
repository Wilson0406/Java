class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        boolean[] vis = new boolean[n];
        long score = 0;
        while(!pq.isEmpty()) {
            int val = pq.peek()[1], ind = pq.peek()[0];
            pq.poll();
            if(vis[ind]) {
                continue;
            }
            vis[ind] = true;
            
            if(ind - 1 >= 0) vis[ind - 1] = true;
            if(ind + 1 < n) vis[ind + 1] = true;
            score += val;
        }
        return score;
    }
}