class Solution {
    public int maxPoints(int[][] points) {
        int count = 2;
        if(points.length <= 2) return points.length;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int total = 2;
                for(int k = 0; k < points.length; k++) {
                    if(k != i && k != j) {
                        if((points[j][1] - points[i][1]) * (points[i][0] - points[k][0]) == (points[i][1] - points[k][1]) * (points[j][0] - points[i][0])) total++;
                    }
                }
                count = Math.max(count, total);
            }
        }
        return count;
    }
}