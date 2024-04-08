class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        int i = 0;
        int j = arr.length - 1;
        while(i < arr.length - 1) {
            if(arr[i] < arr[i + 1]) {
                i++;
            } else {
                break;
            }
        }
        if(i == arr.length - 1) return false;
        while(j > 0) {
            if(arr[j] < arr[j - 1]) {
                j--;
            } else {
                break;
            }
        }
        if(j == 0) return false;
        return i == j;
    }
}