class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int max = Integer. MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer val = entry.getValue();
            if(val > max) {
                max = val;
            }
        }
        
        for(int i = 0; i < max; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                // System.out.println(entry.getKey() + " " + entry.getValue());
                if(entry.getValue() != 0) {
                    temp.add(entry.getKey());
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}