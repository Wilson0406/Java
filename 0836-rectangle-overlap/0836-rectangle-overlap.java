class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // bottom left coordinates
        int x1 = Math.max(rec1[0],rec2[0]);
        int y1 = Math.max(rec1[1],rec2[1]);
        // top right coordinates
        int x2 = Math.min(rec1[2],rec2[2]);
        int y2 = Math.min(rec1[3],rec2[3]);
        return x2 > x1 && y2 > y1;
    }
}