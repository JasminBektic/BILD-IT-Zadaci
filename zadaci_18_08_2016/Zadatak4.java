package zadaci_18_08_2016;

import java.util.Scanner;

	/*
	 * Write a method that returns the sum of all the elements in a specified column in a matrix using the following header: 
	 * public static double sumColumn(double[][] m, int columnIndex) Write a test program that reads a 3-by-4 matrix and displays 
	 * the sum of each column.
	 */

public class Zadatak4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] m = new double[3][4];
		System.out.println("Enter a 3-by-4 matrix row by row:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				m[i][j] = input.nextDouble();	//popunjavanje matrice
			}
		}
		input.close();
			//ispis sume svih kolona
		System.out.printf("Sum of the elements at column 0 is %3.1f\n", sumColumn(m, 0));
		System.out.printf("Sum of the elements at column 0 is %3.1f\n", sumColumn(m, 1));
		System.out.printf("Sum of the elements at column 0 is %3.1f\n", sumColumn(m, 2));
		System.out.printf("Sum of the elements at column 0 is %3.1f", sumColumn(m, 3));
	}
		//metoda koja vraca zbir svake kolone
	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum += m[i][columnIndex];			//suma svake kolone
		}
		return sum;
	}
}
