class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, q = queries.length;
        List<int[]>[] que = new ArrayList[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < n; i++) que[i] = new ArrayList<>();
        int res[] = new int[q];
        Arrays.fill(res, -1);
        
        for(int qi = 0; qi < q; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if(i < j && heights[i] < heights[j]) res[qi] = j;
            else if(j < i && heights[j] < heights[i]) res[qi] = i;
            else if(i == j) res[qi] = i;
            else {
                que[Math.max(i, j)].add(new int[]{Math.max(heights[i], heights[j]), qi});
            }
        }
        
        for(int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                res[pq.poll()[1]] = i;
            }
            
            for(int[] qq : que[i]) {
                pq.add(qq);
            }
        }
        return res;
    }
}