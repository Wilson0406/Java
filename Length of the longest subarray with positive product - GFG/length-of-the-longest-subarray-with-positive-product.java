//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        int ans = find(arr, n);
        int i = 0, j = n - 1;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return Math.max(ans, find(arr,n));
    }
    int find(int arr[], int n) {
        int ans = 0, c = 0, i = 0, j = 0;
        while(j < n) {
            if(arr[j] < 0) {
                c++;
            }
            
            if(arr[j] != 0 && c % 2 == 0) {
                ans = Math.max(ans, j - i + 1);
            }
            
            if(arr[j] == 0 && j + 1 < n) {
                i = j + 1;
                c = 0;
            }
            j++;
        }
        return ans;
    }
}