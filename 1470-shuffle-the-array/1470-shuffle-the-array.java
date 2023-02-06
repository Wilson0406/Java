class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[2*n];
        int j = 0;
        int len = nums.length;
        
        for(int i = 0; i < n; i++){
            arr[j] = nums[i];
            j+=2;
        }
        
        j=1;
        for(int i = n; i < 2*n; i++){
            arr[j] = nums[i];
            j+=2;
        }
        return arr;
    }
}