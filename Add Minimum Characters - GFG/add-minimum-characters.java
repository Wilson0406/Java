//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //check the str 0 to e is palindrome or not
   public static boolean check(String str ,int e){
        int s = 0;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            else {
                s++;e--;
            }
        }
        return true;
    }
	public static int addMinChar(String str){
		//code here
		int e=str.length()-1;
        int ans =0;
        for(int i=e;i>0;i--){
            if(check(str, i)) {
                return str.length()-i-1; 
                /*
                if s to e is palindrome so we return e+1 to str.length()
                char add if front to make str to a palindrome
                
                ex: 
                abad so aba is palindrome then we add d if front of str to a palindrome
                */
            }
        }

        return str.length()-1;
	}
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends