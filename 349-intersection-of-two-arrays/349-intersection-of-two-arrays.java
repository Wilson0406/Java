class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        int count = 0;
        int i = 0;
        for(int n: map1.keySet()) {
            if(map2.containsKey(n))
                count++;
        }
        int[] ans = new int[count];
        for(int n: map1.keySet()) {
            if(map2.containsKey(n))
                ans[i++] = n;
        }
        return ans;
    }
}