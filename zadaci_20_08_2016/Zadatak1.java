package zadaci_20_08_2016;

import java.util.Arrays;
import java.util.Scanner;

	/*
	 * Implement the following method to sort the rows in a twodimensional array. A new array is returned and the original array is intact. 
	 * public static double[][] sortRows(double[][] m) Write a test program that prompts the user to enter a 3 * 3 matrix of double values and 
	 * displays a new row-sorted matrix.
	 */

public class Zadatak1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		double[][] m = new double[3][3];
		System.out.println("Enter 3x3 matrix (row by row):");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = check();
			}
		}
		for (double[] ex : sortRows(m)) {
			System.out.println(Arrays.toString(ex));	//printanje sortirane matrice
		}
	}
		//metoda koja sortira redove matrice
	public static double[][] sortRows(double[][] m) {
		double[][] matrix = new double[3][3];
		for (int i = 0; i < m.length; i++) {
			Arrays.sort(m[i]);					//sortiranje reda
			matrix[i] = m[i];					//dodaj sortiran red novoj 2D matrici
		}
		return matrix;
	}
		//metoda za provjeru unosa
	public static double check() {
		double num = 0;
		do {
			try {	
				num = input.nextDouble();	//unos
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
