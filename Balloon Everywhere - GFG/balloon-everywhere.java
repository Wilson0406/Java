//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        String ip = "balloon";
        int[] map = new int[26];
        int count = 0;
        
        for(char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        
        while(true) {
            int i;
            for(i = 0; i < ip.length(); i++) {
                if(map[ip.charAt(i) - 'a'] == 0) {
                    break;
                } else {
                    map[ip.charAt(i) - 'a']--;
                }
            }
            
            if(i <= ip.length() - 1) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}