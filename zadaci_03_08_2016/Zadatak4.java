package zadaci_03_08_2016;

import java.util.Scanner;

public class Zadatak4 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] matrix = new double[3][3];  // velicina matrice
		
		System.out.println("Unesite elemente matrice: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = input.nextDouble();  // unos elemenata u matricu
		}
			input.close();
			for (int i = 0; i < matrix.length; i++) {		
				for (int j = 0; j < matrix[i].length; j++)
					System.out.print(matrix[i][j] + " ");  // printanje matrice
				System.out.println();
			}
			int[] element = locateLargest(matrix);		
			System.out.printf("Lokacija najveceg elementa u matrici je (%d,%d)",element[0],element[1]);  // ispis lokacije najveceg broja
	}
	
	
	public static int[] locateLargest(double[][] a) {	
		int[] element = new int[2];		
		double max = a[0][0];		
		for (int i = 0; i < a.length; i++) {	
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {	
					max = a[i][j];		// novi max
					element[0] = i;		// novi indexi
					element[1] = j;
				}					
			}
		}
		return element;
	}
}