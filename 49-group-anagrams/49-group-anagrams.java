class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> bmap = new HashMap<>();
        
        for(String str : strs) {
            HashMap<Character, Integer> fmap = new HashMap<>();
            for (int i=0; i<str.length();i++) {
                char ch = str.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            if(bmap.containsKey(fmap) == false) {
                List<String> list = new ArrayList<String>();
                list.add(str);
                bmap.put(fmap,list);
            } else {
                List<String> list = bmap.get(fmap);
                list.add(str);
            }
            // return res;
        }
            List<List<String>> res = new ArrayList<>();
            for(List<String> val: bmap.values()) {
                res.add(val);
            }
        return res;
    }
}