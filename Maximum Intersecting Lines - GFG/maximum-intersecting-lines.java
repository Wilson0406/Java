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

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxIntersections(int[][] lines, int N) {
        // Code here
        //Arrays.sort(lines,Comparator.comparingInt(o -> o[0]));
        int count = 0 , maxCount = 0;
        int a[] = new int[N];
        int b[] = new int[N];
        for(int i=0;i<N;i++){
            a[i] = lines[i][0];
            b[i] = lines[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0 , j = 0;
        while(i<N){
            if(a[i] <= b[j]){
                count++;
                maxCount = Math.max(count,maxCount);
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return maxCount;
    }
}