class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> fm = new HashMap<>(), hm = new HashMap<>();
        for(int i: nums) {
            fm.put(i,fm.getOrDefault(i,0)+1);
        }
        for(int i: nums) {
            if(fm.get(i) == 0) {
                continue;
            }
            if(hm.getOrDefault(i,0) > 0) {
                hm.put(i,hm.get(i)-1);
                hm.put(i+1,hm.getOrDefault(i+1,0)+1);
            } else if(fm.getOrDefault(i+1,0) > 0 && fm.getOrDefault(i+2,0) > 0) {
                fm.put(i+1,fm.get(i+1)-1);
                fm.put(i+2,fm.get(i+2)-1);
                hm.put(i+3,hm.getOrDefault(i+3,0)+1);
            } else return false;
            fm.put(i,fm.get(i)-1);
        }
        return true;
    }
}