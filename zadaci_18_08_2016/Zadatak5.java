package zadaci_18_08_2016;

import java.util.Arrays;
import java.util.Scanner;

	/*
	 * Write a method to add two matrices. The header of the method is as follows: 
	 * public static double[][] addMatrix(double[][] a, double[][] b) In order to be added, the two matrices
	 * must have the same dimensions and the same or compatible types of elements. Write a test program that prompts 
	 * the user to enter two 3 * 3 matrices and displays their sum.
	 */

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		System.out.println("Enter matrix1 (3x3):");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = input.nextDouble();			//unos brojeva u matricu1
			}
		}
		System.out.println("Enter matrix1 (3x3):");
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				b[i][j] = input.nextDouble();			// unos brojeva u matricu2
			}
		}
		input.close();
		System.out.print(Arrays.deepToString(addMatrix(a, b)));		//ispis sumiranih matrica
	}
		//metoda koja vraca zbir matrica a i b
	public static double[][] addMatrix(double[][] a, double[][] b) {
		double[][] c = new double[3][3];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = a[i][j] + b[i][j];		//zbir matrica
			}
		}
		return c;
	}
}
