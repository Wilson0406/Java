class Solution {
    public double myPow(double x, int n) {
        if(n==0 || x==1)
            return 1;
        if(n<0) {
            n = Math.abs(n);
            x = 1/x;
        }
        double res = n%2==0? myPow(x*x,n/2) : x*myPow(x*x,n/2);
        
        return n<0 ? 1/res:res;
    }
}