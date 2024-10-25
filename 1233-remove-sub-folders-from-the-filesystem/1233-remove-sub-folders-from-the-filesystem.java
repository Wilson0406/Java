class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s : folder) {
            set.add(s);
        }
        
        for(String s : folder) {
            String temp = s;
            boolean subFolder = false;
            while(!s.isEmpty()) {
                int pos = s.lastIndexOf('/');
                if (pos == -1) break;
                s = s.substring(0, pos);
                if(set.contains(s)) {
                    subFolder = true;
                    break;
                }
            }
            if(subFolder == false) {
                ans.add(temp);
            }
        }
        return ans;
    }
}