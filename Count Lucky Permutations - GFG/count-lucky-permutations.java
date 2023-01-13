//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            int arr[] = new int[(int)(N)];
int i=0;
            String inputLine2[] = read.readLine().trim().split(" ");
            for (i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
            int graph[][] = new int[M][2];
            for (i = 0; i < M; i++) {
                String S1[] = read.readLine().trim().split(" ");
                graph[i][0] = Integer.parseInt(S1[0]);
                graph[i][1] = Integer.parseInt(S1[1]);
            }

            Solution ob = new Solution();
            System.out.println(ob.luckyPermutations(N, M, arr, graph));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long luckyPermutations(int N, int M, int arr[], int[][] graph) {
        HashSet<Integer>[] edge = new HashSet[N+1];
        for(int i = 0; i <= N; i++) {
            edge[i] = new HashSet<>();
        }
        for(int[] e : graph) {
            edge[e[0]].add(e[1]);
            edge[e[1]].add(e[0]);
        }
        return helper(edge, arr, 0, -1, 0, new Long[N][N+2][1<<N]);
    }
    
    long helper(HashSet<Integer>[] edge, int[] a, int idx, int p_val, int visit, Long[][][] dp) {
        if(idx >= a.length) {
            return 1;
        }
        if(dp[idx][p_val+1][visit] != null) return dp[idx][p_val+1][visit];
        
        long ans = 0;
        for(int i = 0; i < a.length; i++) {
            if((visit&(1<<i)) == 0) {
                if(p_val == -1) {
                    ans += helper(edge, a, idx+1, a[i],visit+(1<<i), dp);
                } else {
                    if(edge[p_val].contains(a[i])) {
                        ans += helper(edge, a, idx+1, a[i], visit+(1<<i), dp);
                    }
                }
            }
        }
        return dp[idx][p_val+1][visit] = ans;
    }
}
