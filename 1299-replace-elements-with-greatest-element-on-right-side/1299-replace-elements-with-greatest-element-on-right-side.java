class Solution {
    public int largest(int arr[], int l) {
        int r = arr.length;
        int max = 0;
        for(int i = l;i < r; i++) {
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int ans[] = new int[len];
        for(int i = 0; i < len - 1; i++) {
            ans[i] = largest(arr,i+1);
        }
        ans[len - 1] = -1;
        return ans;
    }
    
}