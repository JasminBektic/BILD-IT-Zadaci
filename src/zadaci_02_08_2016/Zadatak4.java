package zadaci_02_08_2016;

import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		System.out.println("Unesite broj n (n x n matrica): ");
		int x = 1;
	   do {   // restart metoda, program se resetuje pri pogresnom unosu
		try { 
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			System.out.println("Matrica je: ");
			printMatrix(n);
			input.close();
			x = 2;
		}
		catch (Exception e) {  
			System.out.println("Red Alert! Pogresan unos!! Unesite ponovo: ");
		}
	}
	   while (x == 1);  // restart se ponavlja sve dok x ne bude 2
	}
	
	public static void printMatrix(int n) {  
		int[][] matrix = new int[n][n];  
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int) Math.round(Math.random());  // random popunjena matrica (0-1)
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
