//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution{
    class Pair {
		int include;
		int exclude;

		public Pair(int include, int exclude) {
			this.include = include;
			this.exclude = exclude;
		}
	}

	public class Graph {
		private int v;
		private ArrayList<ArrayList<Integer>> adj;

		public Graph(int v) {
			this.v = v;
			this.adj = new ArrayList<>(this.v);
			for (int i = 0; i < this.v; i++) {
				adj.add(new ArrayList<>());
			}
		}

		public void addEdge(int u, int v) {
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		public Pair dfs(int u, int parent) {
			ArrayList<Pair> list = new ArrayList<>();
			for (int v : adj.get(u)) {
				if (parent != v) {
					list.add(dfs(v, u));
				}
			}
			int include = 1;
			int exclude = 0;
			for (Pair pair : list) {
				include += pair.exclude;
				exclude += Math.max(pair.include, pair.exclude);
			}
			return new Pair(include, exclude);
		}
	}

	public int countVertex(int n, int[][] e) {
		Graph graph = new Graph(n + 1);
		for (int i = 0; i < e.length; i++) {
			graph.addEdge(e[i][0], e[i][1]);
		}
		return n - Math.max(graph.dfs(1, -1).include, graph.dfs(1, -1).exclude);
	}
}

//{ Driver Code Starts.

// } Driver Code Ends