class Solution {
    public int findArea(int x1, int y1, int x2, int y2) {
        return (y2-y1) * (x2-x1);
    }
    
    public int findIntersectionArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        return findArea(Math.max(a,e), Math.max(b,f), Math.min(c,g), Math.min(d,h));
    }
    
    public boolean findIntersection(int lowerone, int upperone, int lowertwo, int uppertwo) {
        return upperone > lowertwo && uppertwo > lowerone;
    }
    
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int intersection = findIntersection(ax1,ax2,bx1,bx2) && findIntersection(ay1,ay2,by1,by2) ? findIntersectionArea(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2) : 0;
        
        return findArea(ax1,ay1,ax2,ay2) + findArea(bx1,by1,bx2,by2) - intersection;
    }
}