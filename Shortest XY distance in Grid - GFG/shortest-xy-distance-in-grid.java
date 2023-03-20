//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N, int M) {
        
        ArrayList<int[]> list1 = new ArrayList<>();
        ArrayList<int[]> list2 = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid.get(i).get(j) == 'X'){
                    list1.add(new int[]{i,j});
                }
                else if(grid.get(i).get(j) == 'Y'){
                    list2.add(new int[]{i,j});
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int[] arr : list1){
            for(int[] arr1 : list2){
                ans = Math.min(ans,Math.abs(arr[0]-arr1[0]) + Math.abs(arr[1]-arr1[1]));
            }
        }
        
        return ans;
        
    }
};