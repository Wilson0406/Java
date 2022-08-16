class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = (2*i) + 1;
        }
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int count;
        if(n % 2 == 0) {
            count = 1;
            for(int i = n - 1; i > (n+1)/2; i--) {
                count = count + (arr[i] - n);
            }
        } else {
            count = 0;
            for(int i = n - 1; i > n/2; i--) {
                count = count + (arr[i] - n);
            }
        }
        return count;
    }
}