//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A,B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        String str = "";
        int temp = 0, ans = 0;
        
        while(str.length() <= 2*B.length()) {
            str += A;
            temp++;
            if(str.contains(B)) {
                ans = temp;
                break;
            }
        }
        
        if(ans == 0) {
            return -1;
        }
        return ans;
    }
};