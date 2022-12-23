//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        if(s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        
        boolean f1 = false, f2 = false;
        int n1 = 0, n2 = 0;
        if(s1.charAt(0) == '-') {
            n1 = 1;
            f1 = true;
        }
        
        if(s2.charAt(0) == '-') {
            n2 = 1;
            f2 = true;
        }
        
        int[] res = new int[s1.length() + s2.length()];
        
        
        for(int i = s1.length() - 1; i >= n1; i--) {
            for(int j = s2.length() - 1; j >= n2; j--) {
                res[i+j+1] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                res[i+j] += res[i+j+1] / 10;
                res[i+j+1] %= 10;
            }
        }
        String ans = "";
        int i = 0;
        for(i = 0; i < res.length; i++) {
            if(res[i] != 0) {
                break;
            }
        }
        
        for(; i < res.length; i++) {
            ans += res[i];
        }
        
        if(f1 == true && f2 == true) {
            return ans;
        }
        if(f1 == true || f2 == true) {
            return "-"+ans;
        }
        
        return ans;
    }
}