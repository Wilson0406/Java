//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int calc(int carp, int box) {
        if(carp <= box) return 0;
        return 1 + calc(carp/2, box);
    }
    
    int carpetBox(int A, int B, int C, int D) { 
        return Math.min(calc(A,C) + calc(B,D), calc(A,D) + calc(B,C));
    }
   
}
