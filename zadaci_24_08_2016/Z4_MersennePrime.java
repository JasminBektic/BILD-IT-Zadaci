package zadaci_24_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * A prime number is called a Mersenne prime if it can be written in the form 2p - 1 for some positive integer p. Write a program 
	 * that finds all Mersenne primes with p … 100 and displays the output as shown below. (Hint: You have to use BigInteger to store 
	 * the number, because it is too big to be stored in long. Your program may take several hours to run.)
	 */

import java.math.BigInteger;

public class Z4_MersennePrime {

	public static void main(String[] args) {
		int counter = 0;
		System.out.println("p\t2^p – 1\n");
	    for (int i = 2; counter < 100; i++) {	//petlja zavrsava kada brojac bude 99
	    if (isPrime(i)) {			//ako je prost broj, ispisi prost broj i Mersenne-ov broj
	    	counter++;
	        System.out.printf("%-10d%-10s\n", i, mersennePrime(i));		//ispis
	    	}
	    }
	}
	//metoda koja provjerava da li je broj prost
	public static boolean isPrime(long num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {			// ako je broj djeljiv sa i, nije prost
				return false;
			}
		}
		return true;
	}
	//metoda koja vraca Mersenne-ov prost broj
	public static BigInteger mersennePrime(int n) {
        return new BigInteger("2").pow(n).subtract(BigInteger.ONE);
    }
}
