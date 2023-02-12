//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    static int isPrime(int n) {
        if(n == 1 || n == 0) {
            return 0;
        }
        
        for(int i = 2; i <= Math.sqrt((double)n); i++) {
            if(n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
    Node primeList(Node head){
        Node list = head;
        
        do {
            int n = list.val;
            if(isPrime(n) == 1) {
                list.val = n;
            } else {
                int num1 = n - 1;
                int num2 = n + 1;
                while(num1 >= 0) {
                    if(isPrime(num1) == 1) {
                        list.val = num1;
                        break;
                    } else if(isPrime(num2) == 1) {
                        list.val = num2;
                        break;
                    }
                    num1--;
                    num2++;
                }
            }
            list = list.next;
        }
        while(list != null);
        return head;
    }
}