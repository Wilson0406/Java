class Solution {
    public int binarySearch(int[][] items, int queryPrice) {
        int l = 0, r = items.length - 1;
        int ans = 0;
        int mid;
        while(l <= r) {
            mid = l + (r - l) / 2;
            if(items[mid][0] > queryPrice) {
                r = mid - 1;
            } else {
                ans = Math.max(ans, items[mid][1]);
                l = mid + 1;
            }
        }
        return ans;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));
        int[] ans = new int[queries.length];
        int maxSoFar = 0;
        for(int i = 0; i < items.length; i++) {
            maxSoFar = Math.max(maxSoFar, items[i][1]);
            items[i][1] = maxSoFar;
        }
        for(int i = 0; i < queries.length; i++) {
            int queryPrice = queries[i];
            ans[i] = binarySearch(items, queryPrice);
        }
        return ans;
    }
}