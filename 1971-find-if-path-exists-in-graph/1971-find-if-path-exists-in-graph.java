class Solution {
    boolean found = false;
    
    private void dfs(HashMap<Integer, List<Integer>> graph, boolean[] visited, int source, int destination) {
        if(visited[source] || found) {
            return;
        }
        visited[source] = true;
        
        for(int connectedNode: graph.get(source)) {
            if(connectedNode == destination) {
                found = true;
                break;
            }
            if(!visited[connectedNode]) {
                dfs(graph, visited, connectedNode, destination);
            }
        }
        
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) {
            return true;
        }
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList());
        }
        
        // bidirectional
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(graph, visited, source, destination);
        
        return found;
    }
}