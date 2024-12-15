class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double ans = 0.0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            double ratio1 = (double)(a[0] + 1) / (a[1] + 1) - (double)a[0] / a[1];
            double ratio2 = (double)(b[0] + 1) / (b[1] + 1) - (double)b[0] / b[1];
            return Double.compare(ratio2, ratio1);
        });
        for(int clas[]: classes) {
            pq.offer(clas);
        }
        
        for(int i = 1; i <= extraStudents; i++) {
            int clas[] = pq.poll();
            clas[0] += 1;
            clas[1] += 1;
            
            pq.offer(new int[]{clas[0], clas[1]});
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int[] clas = pq.poll();
            // System.out.println((double)clas[0]/clas[1]);
            ans += (double) clas[0] / clas[1];
            // System.out.println(ans);
            count++;
        }
        ans = ans / count;
        return ans;
    }
}