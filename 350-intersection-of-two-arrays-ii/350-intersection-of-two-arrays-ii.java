class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] result = new int[length];
        int x=0,y=0,count=0;
        while(x < nums1.length && y < nums2.length){
            if(nums1[x] > nums2[y]){
                y++;
            }
            else if(nums1[x] < nums2[y]){
                x++;
            }
            else{
                result[count] = nums1[x];
                count++;
                x++;
                y++;
            }
        }
        return Arrays.copyOf(result,count);
    }
}