class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            int[] val = {dist, x, y};
            pq.offer(val);
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] val = pq.poll();
            ans[i][0] = val[1];
            ans[i][1] = val[2];
        }
        return ans;
    }
}