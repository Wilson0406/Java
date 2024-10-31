class Solution {
    public int uniquePaths(int M, int N) {
        // int mod = 1000000007;
        int[] prev = new int[N];
        for(int i = 0; i < M; i++) {
            int[] curr = new int[N];
            for(int j = 0; j < N; j++) {
                if(i == 0 && j == 0) curr[j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j - 1];
                    curr[j] = (up + left);
                }
            }
            prev = curr;
        }
        return prev[N - 1];
    }
}