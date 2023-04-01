//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minOperations(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minOperations(int N) {
        if(N == 1){
                return 0;
            } else if(N == 2){
                return 1;
        }
        
        long ibm = -1;
        long res = 0;    
        
        ibm = ((N + 1) / 2) - 1;
        res = (ibm * (ibm + 1));
        
        if(N % 2 == 0){
            res += (ibm + 1);
        }
        
        return res;
    }
}