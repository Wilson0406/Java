//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
     static int check(String s1,String s2) {
        char a1[] = s1.toCharArray();
        char a2[] = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        if(String.valueOf(a1).equals(String.valueOf(a2)))
            return 1;
        return 0;
    }
    static void returnList(String e, ArrayList<Node> ans1){
        Node q= new Node('0');
        Node start=q;
        for(int i=0;i<e.length();i++) {
            q.next=new Node(e.charAt(i));
            q=q.next;
        }
        ans1.add(start.next);
    }

    public static ArrayList<Node> findAnagrams(Node head, String s) {
        String s1 = "";
        ArrayList<Node> l = new ArrayList<>();
        while(head!=null) {
            s1 += head.data;
            if(s1.length()==s.length()) {
                if(check(s1,s)==1) {
                    returnList(s1,l);
                    s1="";
                }else {
                    s1=s1.substring(1);
                }
            }
            head = head.next;
        }
        return l;
    }
}