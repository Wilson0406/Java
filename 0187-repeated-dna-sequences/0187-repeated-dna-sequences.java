class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String str1 = s.substring(i, i + 10);
            if(s.substring(i).contains(str1)) {
                map.put(str1, map.getOrDefault(str1,0)+1);
                // System.out.println(s.substring(i));
                // System.out.println(str1);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}