class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();
        for(int ar : arr1) {
            String a = String.valueOf(ar);
            int l = a.length();
            for(int i = 0; i <= l; i++) {
                String substr = a.substring(0, i);
                set.add(substr);
            }
        }
        int len = 0;
        for(int ar : arr2) {
            String a = String.valueOf(ar);
            int l = a.length();
            for(int i = 0; i <= l; i++) {
                String substr = a.substring(0, i);
                if(set.contains(substr)) {
                    len = Math.max(len, substr.length());
                }
            }
        }
        return len;
    }
}