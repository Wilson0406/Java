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
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);
            
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<m; i++)
            {
                String S2[] = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);
                
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);
                
                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n,m,a,b,edges));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] dijkstra(int a,int n,ArrayList<ArrayList<ArrayList<Integer>>> graph) {
        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[a]=0;
        boolean[] visited=new boolean[n+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->{
            return x[0]-y[0];
        });

        pq.add(new int[]{0,a});
        while(!pq.isEmpty()) {
            int u=pq.poll()[1];
            visited[u]=true;
            for(ArrayList<Integer> al:graph.get(u)) {
                int v=al.get(0),wt=al.get(1);
                if(visited[v]==false && dist[u]!=(int)1e9 && dist[u]+wt<dist[v]) {
                    dist[v]=dist[u]+wt;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        return dist;
    }

    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph=new ArrayList<>();
        ArrayList<int[]> curved=new ArrayList<>();

        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(ArrayList<Integer> edge:edges) {
            int u=edge.get(0),v=edge.get(1),w1=edge.get(2),w2=edge.get(3);
            curved.add(new int[]{u,v,w2});
            ArrayList<Integer> t1=new ArrayList<>();
            t1.add(v); t1.add(w1);
            ArrayList<Integer> t2=new ArrayList<>();
            t2.add(u); t2.add(w1);
            graph.get(u).add(t1);
            graph.get(v).add(t2);
        }

        int[] da=dijkstra(a,n,graph);
        int[] db=dijkstra(b,n,graph);
        int ans=da[b];

        for(int[] edge:curved) {
            int u=edge[0],v=edge[1],wt=edge[2];
            ans=Math.min(ans,da[u]+wt+db[v]);
            ans=Math.min(ans,db[u]+wt+da[v]);
        }
        if(ans>=(int)1e9) return -1;
        return ans;
    }
};