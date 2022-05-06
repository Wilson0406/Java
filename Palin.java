/*
A palindrome is a word, phrase, number, or other sequence of 
characters which reads the same backwards and forwards. Can you 
determine if a given string, s, is a palindrome?
To solve this challenge, we must first take each character in s, enqueue it in a 
queue, and also push that same character onto a stack. Once that's done, we must 
dequeue the first character from the queue and pop the top character off the stack, 
then compare the two characters to see if they are the same; as long as the 
characters match, we continue dequeueing, popping, and comparing each 
character until our containers are empty (a non-match means s isn't a palindrome).

Write the following declarations and implementations:
Two instance variables: one for your stack, and one for your queue
A void pushCharacter(char ch) method that pushes a character onto a stack.
A void enqueueCharacter(char ch) method that enqueues a character in the 
queue instance variable.
A char popCharacter() method that pops and returns the character at the top of 
the stack instance variable.
A char dequeueCharacter() method that dequeues and returns the first 
character in the queue instance variable.

*/

import java.util.*;
import java.lang.*;
import java.io.*;
public class Palin{
    public static boolean palin(String s){
        if(s.length()==0 || s.length()==1){
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return palin(s.substring(1,s.length()-1));
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(palin(input)){
            System.out.println("The word, "+input+", is a palindrome.");
        }
        else{
            System.out.println("The word, "+input+", is not a palindrome.");
        }
    }
}



/*

OR
class Palin
{
ArrayDeque<Character> stack = new ArrayDeque();
public void pushCharacter(char ch)
{
stack.push(ch);
}
public char popCharacter()
{
return stack.pop();
}
ArrayDeque<Character> queue = new ArrayDeque();
public void enqueueCharacter(char ch)
{
queue.add(ch);
}
public char dequeueCharacter()
{
return queue.remove();
}
public static void main(String args[])
{
Scanner in = new Scanner(System.in); 
String input = in.nextLine();
in.close();
char [] s = input.toCharArray(); 
Main m = new Main(); 
for(char c: s)
{
m.pushCharacter(c); 
m.enqueueCharacter(c);
}
boolean ispalin = true;
for(int i = 0; i<s.length/2;i++)
{
if(m.popCharacter()!= m.dequeueCharacter())
{
ispalin = false; 
break;
}
}
System.out.println("The word," + input + " , is" + ((!ispalin) ? " not a 
palindrome." : "a palindrome." ));
}
}
*/