class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] < 0)
                count++;
        }
        int[] neg = new int[count];
        int[] pos = new int[len - count];
        int j = 0;
        int k = 0;
        for(int i = 0; i < len; i++) {
            if(nums[i] < 0){
                neg[j] = nums[i];j++;
            }
            else{
                pos[k] = nums[i];k++;
            }
        }
        int[] ans = new int[len];
        j = 0;
        for(int i = 0; i < len; i=i+2) {
            ans[i] = pos[j];
            j++;
        }
        k = 0;
        for(int i = 1; i < len; i=i+2) {
            ans[i] = neg[k];
            k++;
        }
        return ans;
    }
}