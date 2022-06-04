// The sieve of Eratosthenes is one of the most efficient ways to find all primes smaller than n when n is smaller than 10 million.
// Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.


import java.util.*;

/**
 * seivePrime
 */
public class sievePrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = in.nextInt();
        boolean isP[] = seiveofEratoSthenes(n);
        System.out.println("Prime numbers till " + n + " are: ");
        for (int i = 0; i < isP.length; i++) {
            if (isP[i] == true) {
                System.out.println(i);
            }
            // System.out.println(i + " : " + isP[i]);
        }
    }
    static boolean[] seiveofEratoSthenes(int n) {
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 2*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
    
}