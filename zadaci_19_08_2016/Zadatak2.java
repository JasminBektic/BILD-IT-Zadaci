package zadaci_19_08_2016;

import java.util.Arrays;
import java.util.Scanner;

	/*
	 * Write a method to multiply two matrices. The header of the method is: public static double[][] multiplyMatrix(double[][] a, double[][] b) To multiply matrix a by matrix b, 
	 * the number of columns in a must be the same as the number of rows in b, and the two matrices must have elements of the same or compatible types. Let c be the result of the 
	 * multiplication. Assume the column size of matrix a is n. Each element cij is ai1 * b1j + ai2 * b2j + c + ain * bnj. Write a test program that prompts the user to enter 
	 * two 3 * 3 matrices and displays their product.
	 */

public class Zadatak2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		//unos brojeva u matricu 1
		System.out.println("Enter matrix1 (3x3):");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) 
				a[i][j] = check();
		}
		//unos brojeva u matricu 2
		System.out.println("Enter matrix2 (3x3):");
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) 
				b[i][j] = check();
		}
		System.out.println("The multiplication of the matrices is:");
		System.out.println(Arrays.deepToString(multiplyMatrix(a, b)));		//ispis izmnozenih nizova
	}
		//metoda koja vraca 2D niz pomnozena dva niza
	public static double[][] multiplyMatrix(double[][] a, double[][] b) {
		double[][] c = new double[3][3];
		int counter = 0;
		double sum = 0;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				for (int k = 0; k < c.length; k++) {
					sum += a[i][k] * b[k][j];		//mnozenje i sumiranje brojeva za rezultat svakog c reda
					counter++;
					if (counter == 3) {
						c[i][j] = sum;				//dodjeljivanje broja u odgovarajuci c index
						counter = 0;
						sum = 0;
					}
				}
			}
		}
		return c;
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
