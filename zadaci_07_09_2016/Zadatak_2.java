package zadaci_07_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a recursive method that displays a string reversely on the console using the following header: public static void reverseDisplay(String value)
	 * For example, reverseDisplay("abcd") displays dcba. Write a test program that prompts the user to enter a string and displays its reversal.
	 */

import java.util.Scanner;

public class Zadatak_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		//creating Scanner object
		System.out.println("Enter string:");
		String s = input.next();
		input.close();
		
		reverseDisplay(s);		//calling method
	}
	
	/* Recursive method for displaying string in reverse */
	public static void reverseDisplay(String value) {
		if(!(value.length() < 1)) {
			System.out.print(value.charAt(value.length() - 1));
		    reverseDisplay(value.substring(0, value.length() - 1));
		}
	}
}