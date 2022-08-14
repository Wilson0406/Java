class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];
        for(int i = 0; i < indices.length; i++) {
            ans[indices[i]] = s.charAt(i);
        }
        String res = String.valueOf(ans);
        return res;
    }
}