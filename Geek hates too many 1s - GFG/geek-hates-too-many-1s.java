//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        // code here
        int[] num=new int[32];
        int i=31;
        while(n>0){
            num[i]=(n%2==0)?0:1;
            n/=2;
            i--;
        }
        
        i=2;
        int[] w=new int[3];
        while(i<32){
            if(num[i]==1 && num[i]==num[i-1] && num[i-1]==num[i-2]){
                num[i]=0;
            }
            i++;
        }
        
        i=0;
        int ans=0;
        while(i<32){
            ans=ans*2+num[i];
            i++;
        }
        return ans;
    }
}
