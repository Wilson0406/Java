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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int mod = 1000000007;
    public int CountWays(String str)
    {
        int[][] dp = new int[str.length()][27];
        for(int[] r : dp) Arrays.fill(r, -1);
        return helper(0, str, 0, dp);
    }
    public int helper(int i, String str, int curr, int[][] dp) {
        if(curr > 26) return 0;
        if(i == str.length()) {
            if(curr > 0 && curr <= 26) return 1;
            return 0;
        }
        
        if(dp[i][curr] != -1) return dp[i][curr];
        int take = 0, notTake = 0;
        
        int x = curr * 10 + (str.charAt(i) - '0');
        if(x > 9 && x <= 26) take = helper(i+1, str, x, dp)%mod;
        if(str.charAt(i) - '0' != 0) {
            notTake = helper(i+1, str, str.charAt(i) - '0', dp)%mod;
        }
        return dp[i][curr] = (take+notTake)%mod;
    }
}