//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            int n=Integer.parseInt(in.readLine().trim());
            int a[]=new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            s=in.readLine().trim().split(" ");
            int time[]=new int[n];
            for(int i=0;i<n;i++){
                time[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans=ob.totalTime(n,a,time);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long totalTime(int n, int[] arr, int[] time) {
        long[] a = new long[n];
        Arrays.fill(a, -1);
        long curr = 0;
        for (int i = 0; i < n; i++) {
            if (a[arr[i] - 1] == -1) {
                a[arr[i] - 1] = curr;
            } else {
                if (curr < a[arr[i] - 1] + time[arr[i] - 1]) {
                    curr = a[arr[i] - 1] + time[arr[i] - 1];
                }
                a[arr[i] - 1] = curr;
            }
            curr++;
        }
        return curr - 1;
    }
}