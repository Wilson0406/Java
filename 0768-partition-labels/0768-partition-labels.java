class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int[] a = new int[26];
        Arrays.fill(a, -1);
        for(int i = n - 1; i >= 0; i--) {
            if(a[s.charAt(i) - 'a'] == -1) a[s.charAt(i) - 'a'] = i;
        }

        int ch = -1;
        int prev = 0;
        for(int i = 0; i < n; i++) {
            ch = Math.max(a[s.charAt(i) - 'a'], ch);

            if(ch == i) {
                ans.add(i - prev + 1);
                prev = i + 1;
            }
        }
        return ans;
    }
}