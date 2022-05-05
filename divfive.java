/*
Write a java program to create a own exception called DivisiblebyFiveException 
it should display a message called "Number should not be divided by five". Get an 
input from the user.
If number divisble by 5 it should raise an exception called DivisiblebyFiveException.
Otherwise Print Valid Number.

*/

import java.util.*;

class DivisiblebyFiveExceptopn extends Exception{
    DivisiblebyFiveException(){
        System.out.println("DivisiblebyFiveException: Number should not be divisible by five");
    }
}

class divfive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        try{
            if(num%5==0){
                throw new DivisiblebyFiveException();
            }
            else{
                System.out.println("Valid Number");
            }
        }
        catch(DivisiblebyFiveExceptopn e){
            System.out.println(e.getMessage());
        }
    }
}