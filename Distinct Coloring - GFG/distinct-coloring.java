//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        long[][] dp = new long[3][N];
        
        dp[0][N-1] = r[N-1];
        dp[1][N-1] = g[N-1];
        dp[2][N-1] = b[N-1];
        
        for(int col = N - 2; col >= 0; col--) {
            dp[0][col] = Math.min(dp[1][col+1], dp[2][col+1]) + r[col];
            dp[1][col] = Math.min(dp[0][col+1], dp[2][col+1]) + g[col];
            dp[2][col] = Math.min(dp[0][col+1], dp[1][col+1]) + b[col];
        }
        
        long min = dp[0][0];
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, dp[i][0]);
        }
        return min;
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends