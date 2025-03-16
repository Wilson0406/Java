class Solution {
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[i] = true;
        for(int k : adj.get(i)) {
            if(!vis[k]) dfs(k, adj, vis);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] != 0 && (i != j)) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }
}