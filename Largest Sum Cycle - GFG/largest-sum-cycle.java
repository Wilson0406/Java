//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    long res = -1;
    void dfs(int node, int prev, List<List<Integer>> g, long[] sum, long[] vis, long[] path) {
        sum[node] = sum[prev] + node;
        vis[node] = 1;
        path[node] = 1;
        for(int it : g.get(node)) {
            if(path[it] == 1) {
                res = Math.max(res, sum[node] - sum[it] + it);
            } else if(vis[it] == 0) {
                dfs(it, node, g, sum, vis, path);
            }
        }
        path[node] = 0;
    }
    public long largesSumCycle(int N, int Edge[]){
        List<List<Integer>> g = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
            if(Edge[i] != -1) {
                g.get(i).add(Edge[i]);
            }
        }
        
        long[] sum = new long[N+1];
        long[] vis = new long[N];
        long[] path = new long[N];
        for(int i = 0; i < N; i++) {
            if(vis[i] == 0) {
                dfs(i, N, g, sum, vis, path);
            }
        }
        return res;
    }
}