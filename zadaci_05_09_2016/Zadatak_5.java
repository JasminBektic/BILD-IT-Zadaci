package zadaci_05_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that prompts the user to enter a decimal number and displays the number in a fraction. Hint: read the decimal 
	 * number as a string, extract the integer part and fractional part from the string, and use the BigInteger implementation of the 
	 * Rational class in Programming Exercise 13.15 to obtain a rational number for the decimal number.
	 */

import java.math.BigDecimal;
import java.util.Scanner;

public class Zadatak_5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] str = new String[2];
		System.out.println("Enter a decimal number: ");
		String s = input.next();
		String sum = "";
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '.') {
				sum = sum + s.charAt(i);
			}
			if (s.charAt(i) == '.') {		//First number in list
				  str[0] = sum;
				  sum = "";
			  	} 
		}
		str[1] = sum;  		//Add second number to list
		input.close();
		int d = str[1].length();
		
		/* Using BigIntegerRational class to convert decimal number to fraction number */
		BigIntegerRational n1 = new BigIntegerRational(new BigDecimal(str[0]), BigDecimal.ONE);
		BigIntegerRational n2 = new BigIntegerRational(new BigDecimal(str[1]), BigDecimal.TEN.pow(d));
		BigIntegerRational n = n1.add(n2);
		
		/* Printing fraction number */
		System.out.println("The fraction number is " + n);
	}
}