class Solution {
    public int dfs(List<List<Integer>> map, boolean[] visited, List<Boolean> hasApple, int idx) {
        int result = 0;
        visited[idx] = true;
        for(int i : map.get(idx)) {
            if(!visited[i])
                result += dfs(map, visited, hasApple, i);
        }
            if(idx == 0) return result;
            return result + ((hasApple.get(idx) || result > 0) ? 2 : 0);
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> map = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<>(0));
        }
        
        boolean[] visited = new boolean[n];
        
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        return dfs(map, visited, hasApple, 0);
    }
}