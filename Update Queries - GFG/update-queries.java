//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int Q = Integer.parseInt(str[1]);
			int [][] U = new int[Q][3];
			int i = 0;
			while(i < Q) {
				str = br.readLine().trim().split(" ");
				U[i][0] = Integer.parseInt(str[0]);
				U[i][1] = Integer.parseInt(str[1]);
				U[i][2] = Integer.parseInt(str[2]);
				i++;
			}
			Solution obj = new Solution();
			int [] arr = obj.updateQuery(N, Q, U);
			for(int j: arr) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] updateQuery(int N, int Q, int [][]U){
        int[] ans = new int[N];
        int[][] bit = new int[N+1][32];
        for(int i = 0; i < Q; i++) {
            for(int j = 0; j < 32; j++) {
                if(((U[i][2] >> j) & 1) != 0) {
                    bit[U[i][0] - 1][j] += 1;
                    bit[U[i][1]][j] -= 1;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            int val = 0;
            for(int j = 0; j < 32; j++) {
                if(i != 0) bit[i][j] += bit[i-1][j];
                if(bit[i][j] > 0) {
                    val += (1<<j);
                }
            }
            ans[i] = val;
        }
        return ans;
    }
}