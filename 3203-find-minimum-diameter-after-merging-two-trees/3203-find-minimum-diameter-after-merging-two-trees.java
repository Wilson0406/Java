class Solution {
    public List<Integer> BFS(Map<Integer, List<Integer>> adj, int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        
        q.add(sourceNode);
        visited.put(sourceNode, true);
        
        int maxDistance = 0, farthestNode = sourceNode;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int currNode = q.poll();
                farthestNode = currNode;
                
                for(int neighbour : adj.getOrDefault(currNode, new ArrayList<>())) {
                    if(!visited.getOrDefault(neighbour, false)) {
                        visited.put(neighbour, true);
                        q.add(neighbour);
                    }
                }
            }
            if(!q.isEmpty()) {
                maxDistance++;
            }
        }
        return Arrays.asList(farthestNode, maxDistance);
    }
    public int findDiameter(Map<Integer, List<Integer>> adj) {
        List<Integer> farthestNode = BFS(adj, 0);
        
        farthestNode = BFS(adj, farthestNode.get(0));
        return farthestNode.get(1);
    }
    public Map<Integer, List<Integer>> buildAdj(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] edge: edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adj;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> adj1 = buildAdj(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdj(edges2);
        
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);
        
        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;
        
        return Math.max(d1, Math.max(d2, combined));
        
    }
}