class Solution {
    int ans;
    public int longestPath(int[] parent, String s) {
        ans = 0;
        ArrayList<Integer>[] children = new ArrayList[parent.length];
        
        for(int i = 0; i < parent.length; i++) {
            children[i] = new ArrayList<>();
        }
        
        for(int i = 1; i < parent.length; i++) {
            children[parent[i]].add(i);
        }
        
        dfs(children, s, 0);
        return ans;
    }
    
    public int dfs(ArrayList<Integer>[] children, String s, int i) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int j : children[i]) {
            int curr = dfs(children, s, j);
            if(s.charAt(j) != s.charAt(i)) {
                queue.offer(-curr);
            }
        }
        
        int big1 = queue.isEmpty() ? 0 : -queue.poll();
        int big2 = queue.isEmpty() ? 0 : -queue.poll();
        
        ans = Math.max(ans, big1 + big2 + 1);
        return big1 + 1;
    }
}