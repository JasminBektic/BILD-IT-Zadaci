package zadaci_06_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The gcd(m, n) can also be defined recursively as follows:
	 * ■ If m % n is 0, gcd(m, n) is n.
	 * ■ Otherwise, gcd(m, n) is gcd(n, m % n).
	 * Write a recursive method to find the GCD. Write a test program that prompts the user to enter two integers 
	 * and displays their GCD.
	 */

import java.util.Scanner;

public class Zadatak_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		//Creating new object
		System.out.println("Enter number one: ");
		int number1 = input.nextInt();			//First number
		System.out.println("Enter number two: ");
		int number2 = input.nextInt();
		input.close();

		/* Final result */
		System.out.print("Greatest common divisor is: " + gcd(number1, number2));
	}
	
	/* Method finding greatest common divisor */
	public static int gcd(int m, int n) {
		if (m % n == 0) {
			return n;
		}
		else
			return gcd(n, m % n);
	}
}