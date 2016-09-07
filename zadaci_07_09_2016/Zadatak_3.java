package zadaci_07_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a recursive method that finds the number of occurrences of a specified letter in a string using the following method header: 
	 * public static int count(String str, char a) For example, count("Welcome", 'e') returns 2. Write a test program that prompts the user 
	 * to enter a string and a character, and displays the number of occurrences for the character in the string.
	 */

import java.util.Scanner;

public class Zadatak_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		//creating new object
		System.out.println("Enter string:");
		String s = input.next();		//string input
		System.out.println("Enter character:");
		char ch = input.next().charAt(0);	//character input
		input.close();
		
		System.out.println("Number of occurrences: " + count(s, ch));	//print number of occurrences
	}
	
	/* Recursive method for counting occurrences of a specified character */
	public static int count(String str, char a) {
		int count = 0;
		if (str.length() != 0) {
			if (str.charAt(0) == a) {
				count++;
			}
			return count += count(str.substring(1), a);		//calling method without first char
		}
		return count;
	}
}