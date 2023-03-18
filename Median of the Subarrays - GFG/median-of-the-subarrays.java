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
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    public static long countSubarray(int N, int[] A, int M) {
        return getSubarrayCount(N, A, M) - getSubarrayCount(N, A, M + 1);
    }
        
    public static long getSubarrayCount(int n, int[] arr, int m) {
        int[] freq = new int[2 * n + 1];
        
        long total = 0, count = 0;
        int curSum = n;
        freq[curSum]++;
        
        for (int i = 0; i < n; i++) {
            int diff = -1;
            if (arr[i] >= m) {
                diff = 1;
            }
            
            if (diff == -1) {
                total -= freq[(curSum + diff)];
            } else {
                total += freq[curSum];
            }
            
            curSum += diff;
            count += total;
            freq[curSum]++;
        }
        
        return count;
    }
} 