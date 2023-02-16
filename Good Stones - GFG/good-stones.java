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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int goodStones(int n, int[] arr) {
        Boolean [] v = new Boolean[n];
        int ans=0;
        for(int i=0; i<n; i++){
            rec(i, v, arr, n);
        }
        for(boolean k: v) if(k) ans++;
        return ans;
    }
    
    public static boolean rec(int i, Boolean [] v, int[]a, int n){
        if(i>=n || i<0) return true;
        if(v[i]!=null && v[i]== false) return false;
        v[i]= false;
        v[i]= rec(i+a[i], v, a, n);
        return v[i];
    }
}
        
