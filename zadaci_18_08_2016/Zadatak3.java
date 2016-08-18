package zadaci_18_08_2016;

import java.util.Scanner;

	/*
	 * Write the following method that tests whether the array has four consecutive numbers with the same value. public static boolean isConsecutiveFour(int[] values) 
	 * Write a test program that prompts the user to enter a series of integers and displays if the series contains four consecutive numbers with the same value. 
	 * Your program should first prompt the user to enter the input size—i.e., the number of values in the series.
	 */

public class Zadatak3 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of values:");
		//unos velicine niza i elemenata
		int valueSize = check();
		int[] values = new int[valueSize];
		System.out.println("Enter the values:");
		for (int i = 0; i < valueSize; i++) {
			values[i] = check();
		}
		input.close();
		//poziv metode i ispis rezultata
		String str = (isConsecutiveFour(values)) ? "The list has consecutive fours" : "The list has no consecutive fours";
		System.out.println(str);
	}
		//metoda koja vraca true za cetiri broja u nizu ili false
	public static boolean isConsecutiveFour(int[] values) {
		int counter = 0;
		int temp = values[0];
		for (int i = 0; i < values.length; i++) {
			if (temp == values[i]) {		//ako je pocetni broj jednak sledecem u nizu, povecaj brojac za 1
				counter++;
				if (counter == 4) 			//ako je brojac jednak 4, vrati true
					return true;
			}
				if (temp != values[i]) {	//ako pocetni broj nije jednak sledecem, temp ce biti taj sledeci broj
					temp = values[i];
					counter = 1;
			 }
		}
		return false;
	}
		// metoda za provjeru unosa
	public static int check() {
		int num = 0;
		do {
			try {
				num = input.nextInt();		//unos
				break;
			}
			catch (Exception e) {			//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		} while (true);
		return num;
	}
}
