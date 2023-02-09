//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean help(int u, int[][] G, boolean[] jobs, int[] visit) {
        int n = G.length;
        int m = G[0].length;
        for(int v = 0; v < m; v++) {
            if(G[u][v] == 1 && !jobs[v]) {
                jobs[v] = true;
                if(visit[v] < 0 || help(visit[v], G, jobs, visit)) {
                    visit[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
    public int maximumMatch(int[][] G)
    {
        int appointedJob = 0;
        int n = G.length;
        int m = G[0].length;
        int[] visit = new int[m];
        for(int i = 0; i < m; i++) visit[i] = -1;
        for(int i = 0; i < n; i++) {
            boolean[] jobs = new boolean[m];
            if(help(i, G, jobs, visit)) appointedJob++;
        }
        return appointedJob;
    }
}