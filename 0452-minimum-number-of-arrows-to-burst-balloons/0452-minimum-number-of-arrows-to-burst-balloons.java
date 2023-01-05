class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> (a[1] - b[1]));
        int n = points.length;
        if(n < 2) return n;
        int arrow = 1, pre = points[0][1];
        for(int i = 1; i < n; i++) {
            if(points[i][0] <= pre && pre <= points[i][1]) {
                continue;
            } else {
                arrow++;
                pre = points[i][1];
            }
        }
        return arrow;
    }
}