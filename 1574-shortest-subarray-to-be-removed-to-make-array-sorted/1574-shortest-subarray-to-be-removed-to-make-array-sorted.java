class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while(j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }
        // if(j == 0) return 0;
        // res = j takes care of the sorted array if before j there is no increasing subarray
        int res = j;
        while(i < j && (i == 0 || arr[i] >= arr[i - 1])) {
            while(j < n && arr[i] > arr[j]) {
                j++;
            }
            res = Math.min(res, j - i - 1);
            i++;
        }
        return res;
    }
}