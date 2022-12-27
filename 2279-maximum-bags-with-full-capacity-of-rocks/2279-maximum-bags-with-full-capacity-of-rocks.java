class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] arr = new int[rocks.length];

        for(int i = 0; i < capacity.length; i++) {
            arr[i] = capacity[i] - rocks[i];
        }
        
        int ans = 0;
        Arrays.sort(arr);
        int count = 0;
        for(int a: arr) {
            count += a;
            if(count > additionalRocks) break;
            ans++;
        }
        return ans;
    }
}