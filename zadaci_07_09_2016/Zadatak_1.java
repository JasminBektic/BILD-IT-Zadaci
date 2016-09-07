package zadaci_07_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a recursive method that displays an int value reversely on the console using the following 
	 * header: public static void reverseDisplay(int value) For example, reverseDisplay(12345) displays 54321.
	 * Write a test program that prompts the user to enter an integer and displays its reversal.
	 */

import java.util.Scanner;

public class Zadatak_1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter integer:");
		int value = check();
		reverseDisplay(value);		//calling method
	}
	
	/* Recursive method for displaying number in reverse */
	public static void reverseDisplay(int value) {
		if (value != 0) {
			System.out.print(value % 10);	//last number
			reverseDisplay(value / 10);		//calling method with new value
		}
	}

	/* Check input method */
	public static int check() {
		int num = 0;
		while(true) {
			try {
				num = input.nextInt();		//input
				break;
			} catch (Exception e) {		//catching exception
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;		//return number
	}
}
