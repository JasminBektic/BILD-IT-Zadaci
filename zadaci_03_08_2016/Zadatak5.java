package zadaci_03_08_2016;

import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite broj redova: ");
		int rows = input.nextInt();  // unos broja redova
		
		System.out.print("Unesite broj kolona: ");
		int columns = input.nextInt();  // unos broja kolona
		
		System.out.print("Unesite elemente: ");
		double[][] matrix = new double[rows][columns];
		for (int i = 0; i < matrix.length; i++) {	
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = input.nextDouble();  // unos elemenata
		}
		
		input.close();
		matrix = sortRows(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");  // ispis sortirane matrice
			System.out.println();
		}
	}
	
	public static double[][] sortRows(double[][] array) {
		for (int i = 0; i < array.length; i++) {	// broji po redovima
			for (int j = 0; j < array[i].length - 1; j++) {	
				for (int k = i + 1; k < array[i].length; k++) {	
					if ( array[i][j] > array[i][k]) {	// uslov za zamjenu elementa sa sledecim elementom	
						double a = array[i][j];
						array[i][j] = array[i][k];
						array[i][k] = a;
					}
				}
			}
		}
		
		return array;
	}
}
