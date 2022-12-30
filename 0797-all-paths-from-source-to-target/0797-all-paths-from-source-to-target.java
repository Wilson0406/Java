class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), graph, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> path, int[][] graph, int curr) {
        path.add(curr);
        
        if(curr == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for(int neighbour : graph[curr]) {
                dfs(res, path, graph, neighbour);
            }
        }
        
        path.remove(path.size() - 1);
    }
}