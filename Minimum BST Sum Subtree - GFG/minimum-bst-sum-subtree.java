//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class val{
    int max;
    int min;
    int sum;
    int length;
    boolean fl;
    val()
    {
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        sum=0;
        length=0;
        fl=false;
    }
}

class Solution {
    static int ans=Integer.MAX_VALUE;
    public static val find(int target, Node root)
    {
        val x=new val();
        if(root.left==null && root.right==null)
        {
            x.max=root.data;
            x.min=root.data;
            x.sum=root.data;
            x.length=1;
            x.fl=true;
            if(x.sum==target)
            ans=Math.min(ans,x.length);
        }
        else
        {
            val a=new val(),b=new val();
            boolean fl=true;
            if(root.left!=null)
            {
                a=find(target,root.left);
                if(!a.fl || root.data<=a.max)
                fl=false;
            }
            if(root.right!=null)
            {
                b=find(target,root.right);
                if(!b.fl || root.data>=b.min)
                fl=false;
            }
            x.length=a.length+b.length+1;
            x.sum=a.sum+b.sum+root.data;
            x.max=Math.max(root.data,Math.max(a.max,b.max));
            x.min=Math.min(root.data,Math.min(a.min,b.min));
            x.fl=fl;
            if(fl==true && x.sum==target)
            ans=Math.min(ans,x.length);
        }
        return x;
    }
    public static int minSubtreeSumBST(int target, Node root) {
        ans=Integer.MAX_VALUE;
        find(target,root);
        if(ans==Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}