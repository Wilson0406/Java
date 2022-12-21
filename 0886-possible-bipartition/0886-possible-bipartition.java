class Solution {
    
    public boolean dfs(List<Integer>[] graph, Integer[] colors, int currNode, int currColor) {
        colors[currNode] = currColor;
        
        for(Integer adjacentNode: graph[currNode]) {
            if(colors[adjacentNode] == null) {
                if(!dfs(graph, colors, adjacentNode, currColor*-1)) {
                    return false;
                }
            } else if(colors[adjacentNode] == currColor) {
                return false;
            }
        }
        return true;
    }
        
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n+1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] dislike: dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        
        Integer[] colors = new Integer[n+1];
        
        for(int i = 1; i <= n; i++) {
            // if node hasnt been colored, color it
            if(colors[i] == null && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
}