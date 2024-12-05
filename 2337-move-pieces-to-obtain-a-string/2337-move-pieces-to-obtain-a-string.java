class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        if(start.equals(target)) return true;
        int n = start.length();
        while(i < n || j < n) {
            while(i < n && start.charAt(i) == '_') i++;
            while(j < n && target.charAt(j) == '_') j++;
            if(i == n || j == n) return i == n && j == n;
            if(i< n && j < n && start.charAt(i) == target.charAt(j)) {
                if(start.charAt(i) == 'L') {
                    if(i < j) return false;
                } else if(start.charAt(i) == 'R') {
                    if(i > j) return false;
                }
                i++;
                j++;
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}