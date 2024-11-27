class Solution {
    public int bfs(int n, List<List<Integer>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int u : graph.get(curr)) {
                // Update with Shortest distance
                if(dist[u] > dist[curr] + 1) {
                    dist[u] = dist[curr] + 1;
                    q.add(u);
                }
            }
        }
        return dist[n - 1];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int ans[] = new int[queries.length];
        int k = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        for(int query[] : queries) {
            int u = query[0], v = query[1];
            graph.get(u).add(v);
            ans[k++] = bfs(n, graph);
        }
        return ans;
    }
}