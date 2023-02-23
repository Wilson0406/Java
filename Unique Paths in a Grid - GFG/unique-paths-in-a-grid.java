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
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static final int mod=1000000007;
    
    static int recurse(int i,int j,int n,int m,int[][]arr,int[][]dp)
    {
        if(i>n || j>m || arr[i][j]==0)
            return 0;
        
        if(i==n && j==m)
            return 1;
            
        if(dp[i][j]!=-1)
            return (dp[i][j])%mod;
        
        dp[i][j] = (recurse(i,j+1,n,m,arr,dp)+recurse(i+1,j,n,m,arr,dp))%mod;
        
        return (dp[i][j])%mod;
    }
    
    static int uniquePaths(int n, int m, int[][] grid) {
        
        if(grid[0][0]==0 || grid[n-1][m-1]==0)
            return 0;
        
        int dp[][]=new int[n+1][m+1];
        
        for(int[]temp:dp)
            Arrays.fill(temp,-1);
        
        return (recurse(0,0,n-1,m-1,grid,dp))%mod;
        
    }
};