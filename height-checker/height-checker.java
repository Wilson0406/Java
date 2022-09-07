class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            arr[i] = heights[i];
        }
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < heights.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(arr[i] != heights[i])
                count++;
        }
        return count;
    }
}