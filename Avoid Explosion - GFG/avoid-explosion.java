//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {
    private int find(int[] parent, int u) {
		if (parent[u] == -1) {
			return u;
		}
		return find(parent, parent[u]);
	}

	private void union(int[] parent, int u, int v) {
		parent[u] = v;
	}

	ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < mix.length; i++) {
			int u = find(parent, mix[i][0] - 1);
			int v = find(parent, mix[i][1] - 1);
			int j = 0;
			for (; j < m; j++) {
				int p = find(parent, danger[j][0] - 1);
				int q = find(parent, danger[j][1] - 1);
				if ((u == p && v == q) || (u == q && v == p)) {
					res.add("No");
					break;
				}
			}
			if (j == m && u == v) {
				res.add("Yes");
			}
			if (j == m && u != v) {
				res.add("Yes");
				union(parent, u, v);
			}
		}
		return res;
	}
}