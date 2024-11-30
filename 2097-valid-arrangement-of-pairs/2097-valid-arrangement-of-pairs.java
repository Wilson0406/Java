class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Build graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for(int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }
        
        // Find start node
        int startNode = pairs[0][0];
        for(int node : adj.keySet()) {
            if(outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }
        
        // Perform DFS to find Euler path
        List<Integer> euler = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(startNode);
        
        while(!st.isEmpty()) {
            int curr = st.peek();
            if(adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                int neighbour = adj.get(curr).remove(adj.get(curr).size() - 1);
                st.push(neighbour);
            } else {
                euler.add(curr);
                st.pop();
            }
        }
        int[][] res = new int[euler.size() - 1][2];
        // Build pairs from Euler path
        Collections.reverse(euler);
        for(int i = 0; i < euler.size() - 1; i++) {
            res[i][0] = euler.get(i);
            res[i][1] = euler.get(i + 1);
        }
        return res;
    }
}