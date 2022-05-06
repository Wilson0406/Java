/*
You are required to compute the power of a number by implementing a calculator. 
Create a class MyCalculator which consists of a single method long power(int, int). 
This method takes two integers n, and p, as parameters and finds np. If either n or p is 
negative, then the method must throw an exception which says " n or p should not be 
negative". Also, if n both p and are zero, then the method must throw an exception 
which says "n and p should not be zero" For example, -4 and -5 would result in 
java.lang.Exception: n or p should not be negative
*/


import java.util.*;
import java.io.*;

class MyCalculator{

    public long power(int n, int p) throws Exception{
        if(n==0 && p==0){
            throw new Exception("n and p should not be zero");
        }
        else if(n<0 || p<0){
            throw new Exception("n and p should not be negative");
        }
        else{
            return(long)(Math.pow(n,p));
        }
    }
}

class MainCalc{
    public static final MyCalculator calc = new MyCalculator();
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int p = sc.nextInt();
            try{
                System.out.println(calc.power(n,p));
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
}