class State {
    int node;
    double prob;
    State(int _node, double _prob) {
        node = _node;
        prob = _prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> map = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            
            map.get(edge[0]).add(new double[]{edge[1], succProb[i]});
            map.get(edge[1]).add(new double[]{edge[0], succProb[i]});
        }
        
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> (((Double)b.prob).compareTo((Double)a.prob)));
        double[] probs = new double[n];
        probs[start_node] = 1.0;
        pq.add(new State(start_node, 1.0));
        
        while(!pq.isEmpty()) {
            State state = pq.poll();
            int parent = state.node;
            double prob = state.prob;
            
            if(parent == end_node) return prob;
            
            for(double[] child : map.getOrDefault(parent,new ArrayList<>())) {
                
                if(probs[(int)child[0]] >= prob * child[1]) continue;
                
                pq.add(new State((int)child[0], prob * child[1]));
                probs[(int)child[0]] = prob * child[1];
            }
        }
        return (double)0;
    }
}