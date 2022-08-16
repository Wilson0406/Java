class Solution {
    public int numberOfMatches(int n) {
        // if(n < 2)
        //     return 0;
        // int m=0, a=0;
        // int tot = 1;
        // while(n!=2) {
        //     if((n & 1) != 1) {
        //         m = n>>1;
        //         a = n>>1;
        //     } else {
        //         m = (n-1)>>1;
        //         a = m + 1;
        //     }
        //     n = a;
        //     tot += m;
        // }
        // return tot;
        
        //LOL super hard
        return n - 1;
    }
}