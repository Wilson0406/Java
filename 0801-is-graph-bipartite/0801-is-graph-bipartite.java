class Solution {
    public boolean check(int i, int n, ArrayList<ArrayList<Integer>> adj, int[] col) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        col[i] = 0;
        while(!q.isEmpty()) {
            int t = q.poll();
            for(int a : adj.get(t)) {
                if(col[a] == -1) {
                    col[a] = 1 - col[t];
                    q.add(a);
                } else if(col[a] == col[t]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0; i< n; i++) adj.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) adj.get(i).add(graph[i][j]);
        }

        int[] col = new int[n];
        Arrays.fill(col, -1);
        for(int i = 0; i < n; i++) {
            if(col[i] == -1) {
                if(check(i, n, adj, col) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}