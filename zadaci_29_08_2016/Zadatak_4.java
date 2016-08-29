package zadaci_29_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that meets the following requirements:
	 * ■ Creates an array with 100 randomly chosen integers.
	 * ■ Prompts the user to enter the index of the array, then displays the corresponding element value. If the specified index is 
	 * out of bounds, display the message Out of Bounds.
	 */

import java.util.Random;
import java.util.Scanner;

public class Zadatak_4 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Random rand = new Random();
		int[] numbers = new int[100];			//kreiranje niza
		for (int i = 0; i < 100; i++) {
			numbers[i] = rand.nextInt(51);		//unos random brojeva
			System.out.print(numbers[i] + " ");		//ispis brojeva
		}
		System.out.println();
		System.out.println("Enter the index of the array:");
		while (true) {
			try {
				int index = input.nextInt();		//unos
				System.out.println("Index value: " + numbers[index]);	//ispis vrijednosti ako je index u odredjenim granicama
				break;
			}
			catch (ArrayIndexOutOfBoundsException e) {		//hvatanje greske
				System.out.println("Index Out of Bounds, try again:");
				input.nextLine();		//ciscenje inputa
			}
		}
	}
}
