package zadaci_07_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a recursive method that returns the largest integer in an array. Write a test program that prompts 
	 * the user to enter a list of eight integers and displays the largest element.
	 */

import java.util.Scanner;

public class Zadatak_5 {

	public static void main(String[] args) {
		int[] array = new int[8];		//creating array
		Scanner input = new Scanner(System.in);	 //new Scanner object
		System.out.println("Enter 8 numbers: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();		//number input
		}
		input.close();
		System.out.println("Max number is: " + findMax(array, 7));	//calling method and print max number
	}
	
	/* Recursive method for finding max number in array */
	public static int findMax(int[] a, int index) {
	    if (index > 0) {
	        return Math.max(a[index], findMax(a, index - 1));
	    } 
	    else {
	        return a[0];
	    }
	}
}