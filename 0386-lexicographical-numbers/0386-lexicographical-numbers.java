class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> in = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            in.add(String.valueOf(i));
        }
        Collections.sort(in);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < in.size(); i++) {
            ans.add(Integer.parseInt(in.get(i)));
        }
        return ans;
    }
}