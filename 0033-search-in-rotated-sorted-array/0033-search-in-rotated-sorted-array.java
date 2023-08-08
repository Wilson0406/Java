class Solution {
    public int bSearch(int[] arr, int target, int l, int r) {
        if(l>r)
            return -1;
        int m = l + (r-l)/2;
        if(arr[m] == target)
            return m;
        if(arr[l] <= arr[m]) {
            if(target >= arr[l] && target <= arr[m]) {
                return bSearch(arr,target,l,m-1);
            } else {
                return bSearch(arr,target,m+1,r);
            }
        }
        if(target >= arr[m] && target <= arr[r]) {
            return bSearch(arr,target,m+1,r);
        }
        return bSearch(arr,target,l,m-1);
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        return bSearch(nums,target,l,r);
    }
}