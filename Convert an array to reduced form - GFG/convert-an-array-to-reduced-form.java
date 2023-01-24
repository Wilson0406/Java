//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        int ar[] = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = arr[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(ar);
        for(int i = 0; i < n; i++) {
            map.put(ar[i],i);
        }
        for(int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        
    }
}