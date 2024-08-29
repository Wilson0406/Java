// [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findParent(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int ultimateP = findParent(parent.get(node));
        parent.set(node,ultimateP);
        return parent.get(node);
    }
    
    public void UnionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        
        for(int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.UnionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        
        int count = 0;
        for(Map.Entry<Integer, Integer> it : map.entrySet()) {
            if(ds.findParent(it.getKey()) == it.getKey()) {
                count++;
            }
        }
        return stones.length - count;
    }
}