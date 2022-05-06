/*
Get 10 integers from user,find and print the second largest number. If all 
numbers are same i.e no second largest number then print -1.
[ Hint:- you may use any Collection classes like 
ArrayList,TreeSet,Hashset,LinkedList..etc]

*/

import java.util.*;
import java.io.*;
import java.lang.*;

class SecondL{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> hs = new HashSet<Integer>();
        int[] array = new int[10];
        for(int i=0;i<10;i++){
            array[i] = sc.nextInt();
            hs.add(array[i]);
        }
        List<Integer> list = new ArrayList<Integer>(hs);
        Collections.sort(list);
        int l = list.size();
        if(l!=1){
            System.out.println(list.get(list.size()-2));
        }
        else{
            System.out.println("-1");
        }
    }
}

/*
OR
class SecondL{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=10;
        int []a = new int[n];
        for(int k=0;k<n;k++) 
            a[k] = sc.nextInt();
        int i;
        Arrays.sort(a); 
        for(i=n-2 ;i>=0 ;i--){
            if(a[i]!=a[n-1]){
            System.out.print(a[i]);
            return;
            }
        }
    System.out.print(-1);
    }
}
*/