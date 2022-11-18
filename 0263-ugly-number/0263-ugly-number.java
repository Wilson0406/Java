class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        int[] prime = {2, 3, 5};
        int i;
        while(n%prime[0] == 0){
            n = n / prime[0];
        }
        while(n%prime[1] == 0){
            n = n / prime[1];
        }
        while(n%prime[2] == 0){
            n = n / prime[2];
        }
    return n==1;
    }
}