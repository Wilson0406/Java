//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X){
        int cnt=0;int flag=0;
        for(int i=0;i<N;i++){
            if(S.charAt(i)=='0')cnt++;
            if(S.charAt(i)=='1'){
                if(cnt-X<=0 && flag==0){
                    cnt=0;
                    flag=1;
                }
                else if(cnt-X<=0 && flag==0) return false;
                if(flag==1 && cnt-2*X<=0 )cnt=0;
                else return false;
                
            }
        }
        if(cnt-X<=0)cnt=0;
        else return false;
        return true;
    }
} 