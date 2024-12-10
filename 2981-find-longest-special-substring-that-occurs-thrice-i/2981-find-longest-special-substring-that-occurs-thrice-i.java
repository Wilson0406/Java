class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringBuilder curr = new StringBuilder();
            for(int j = i; j < n; j++) {
                if(curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j)) {
                    curr.append(s.charAt(j));
                    map.put(curr.toString(), map.getOrDefault(curr.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }
        int ans = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int count = entry.getValue();
            if(count >= 3 && str.length() > ans) {
                ans = str.length();
            }
        }
        return ans == 0 ? -1 : ans;
    }
}