//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int n, int[] arr) {
    int[] coins = new int[n+2];
    coins[0] = 1;
    coins[n+1] = 1;
    for(int i = 1; i <= n; i++) {
        coins[i] = arr[i-1];
    }
    
    int[][] dp = new int[n+2][n+2];
    for(int len = 1; len <= n; len++) {
        for(int start = 1; start + len - 1 <= n; start++) {
            int end = start + len - 1;
            for(int i = start; i <= end; i++) {
                dp[start][end] = Math.max(dp[start][end], coins[start- 1]*coins[i]*coins[end + 1] + dp[start][i - 1] + dp[i + 1][end]);
            }
        }
    }
    return dp[1][n];
  }
}
     