class Solution {
    int n;
    int dp[][];
    public int binarySearch(int[][] events, int endTime) {
        int l = 0, r = n - 1, res = n;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(events[mid][0] > endTime) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    public int solve(int[][] events, int i, int count) {
        if(i >= n || count == 2) {
            return 0;
        }
        if(dp[i][count] != -1) return dp[i][count];
        int nextValidIndex = binarySearch(events, events[i][1]);
        int take = events[i][2] + solve(events, nextValidIndex, count + 1);
        int notTake = solve(events, i + 1, count);
        return dp[i][count] = Math.max(take, notTake);
    }
    public int maxTwoEvents(int[][] events) {
        n = events.length;
        dp = new int[100001][3];
        for(int []row : dp) Arrays.fill(row, -1);
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        return solve(events, 0, 0);
    }
}