class Solution {
    
    public int[] findOriginalArray(int[] changed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(changed.length % 2 != 0)
            return new int[]{};
        Arrays.sort(changed);
        int len = changed.length;
        int[] orig = new int[len/2];
        int j = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(map.containsKey(changed[i]*2) && map.get(changed[i]*2) > 0) {
                map.put(changed[i]*2,map.get(changed[i]*2)-1);
                orig[j] = changed[i];
                j++;
            }
            else {
                map.put(changed[i],map.getOrDefault(changed[i],0)+1);
            }
        }
        return j == orig.length ? orig: new int[0];
        
    }
}