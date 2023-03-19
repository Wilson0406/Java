//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        ArrayList<Integer> B=new ArrayList<>();
        int[] c=new int[N];
        int k=1;
        c[0]=0;
        int[] d=new int[N];
        d[N-1]=0;
        for(int i=0;i<N;i++)
        {
           set1.add(A[i]);
           set2.add(A[(N-1)-i]);
           if(k<N)
           {
            c[k]=set1.size();
            d[(N-1)-k]=set2.size();
           }
           k++;
        }
        for(int i=0;i<N;i++)
        B.add(c[i]-d[i]);
        return B;
    }
}