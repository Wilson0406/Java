class Solution {
    private List<HashSet<Integer>> tree;
    private int[] res;
    private int[] count;
    
    public void postOrder(int root, int pre) {
        for(int i : tree.get(root)) {
            if(i == pre) continue;
            postOrder(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }
    
    public void preOrder(int root, int pre) {
        for(int i : tree.get(root)) {
            if(i == pre) continue;
            res[i] = res[root] - count[i] + (count.length - count[i]);
            preOrder(i, root);
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        res = new int[n];
        count = new int[n];
        
        for(int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        
        for(int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        postOrder(0, -1);
        preOrder(0, -1);
        
        return res;
    }
}