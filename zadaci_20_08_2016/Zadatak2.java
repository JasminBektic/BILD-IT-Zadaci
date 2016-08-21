package zadaci_20_08_2016;

import java.util.Arrays;
import java.util.Scanner;

	/*
	 * The two-dimensional arrays m1 and m2 are strictly identical if their corresponding elements are equal. Write a method that 
	 * returns true if m1 and m2 are strictly identical, using the following header: public static boolean equals(int[][] m1, int[][] m2) 
	 * Write a test program that prompts the user to enter two 3 * 3 arrays of integers and displays whether the two are strictly identical.
	 */

public class Zadatak2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] m1 = new int[3][3];
		int[][] m2 = new int[3][3];
		System.out.println("Enter first matrix (3x3, row by row): ");
		in(m1);
		System.out.println("Enter second matrix (3x3, row by row): ");
		in(m2);
			//ispis rezultata
		String s = (equals(m1, m2)) ? "The two arrays are strictly identical" : "The two arrays are not strictly identical";
		System.out.println(s);
	}
		//metoda koja ispituje da li su dvije matrice striktno identicne
	public static boolean equals(int[][] m1, int[][] m2) {
		int counter = 0;
		for (int i = 0; i < m1.length; i++) {
			if (Arrays.equals(m1[i], m2[i])) {		//uslov za identicnost redova
				counter++;
			}
		}
		return (counter == 3) ? true : false;
	}
		//metoda za provjeru unosa
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
		//metoda za unos elementa u matricu
	public static int[][] in(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = check();
			}
		}
		return m;
	}
}
