//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]matrix, int R, int C){
        int i = 0, j = 0, n = matrix.length, m = matrix[0].length;
        int dir = 0;
        int first = i, second = j;
        int[] ans = new int[2];
        while(i >= 0 && j >= 0 && i < n && j < m) {
            if(matrix[i][j] == 1) {
                dir = (dir + 1) % 4;
                matrix[i][j] = 0;
            }
            first = i;
            second = j;
            if(dir == 0) {
                j++;
            } else if(dir == 1) {
                i++;
            } else if(dir == 2) {
                j--;
            } else {
                i--;
            }
        }
        ans[0] = first;
        ans[1] = second;
        return ans;
    }
}