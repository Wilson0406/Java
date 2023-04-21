//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution{
    static int lev;
    static boolean f;
    static int ans;
    static void dfs(Node root, int home, int k){
        if(root == null)    return;
        if(root.data == home){
            f = true;
            lev = 0;
            ans = home;
            lev++;
            dfs(root.left, home, k);
            lev--;
            lev++;
            dfs(root.right, home, k);
            lev--;
        }else{
            if(!f){
                dfs(root.left, home, k);
                if(f){
                    lev++;
                    lev++;
                    dfs(root.right, home, k);
                    lev--;
                    if(f && lev<=k)
                        ans += root.data;
                }else{
                    dfs(root.right, home, k);
                    if(f){
                        lev++;
                        if(lev<=k){
                            lev++;
                            dfs(root.left, home, k);
                            lev--;
                            ans += root.data;
                        }
                    }
                }
            }else{
                lev++;
                dfs(root.left, home, k);
                lev--;
                lev++;
                dfs(root.right, home, k);
                lev--;
                if(f && lev<=k)
                    ans += root.data;
            }
        }
    }
    static int ladoos(Node root, int home, int k) {
        ans = 0;
        f = false;
        dfs(root, home, k);
        return ans;
    }
}