//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S) {
        int l = S.length();
        String str1 = "pr", str2 = "rp";
        if (Y > X) {
            str1 = "rp";
            str2 = "pr";
            int temp = X;
            X = Y;
            Y = temp;
        }
        while (S.indexOf(str1) != -1) {
            S = S.replaceAll(str1, "");
        }
        
        long x = (l - S.length()) / 2;
        l = S.length();
        while (S.indexOf(str2) != -1) {
            S = S.replaceAll(str2, "");
        }
        long y = (l - S.length()) / 2;
        return x * X + y * Y;
    }
}