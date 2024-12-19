class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = 0;
        for(int i = 1; i < n; i++) {
            prefix[i] = i + prefix[i - 1];
        }
        int ans = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            // System.out.println(prefix[i]);
            if(sum == prefix[i]) ans++;
        }
        return ans;
    }
}