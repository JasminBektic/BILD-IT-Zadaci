package zadaci_19_08_2016;

	/*
	 * Write a program that generates a 6-by-6 two-dimensional matrix filled with 0s and 1s, displays the matrix, and 
	 * checks if every row and every column have an even number of 1s.
	 */

import java.util.Arrays;

public class Zadatak5 {

	public static void main(String[] args) {
		int[][] matrix = new int[6][6];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = (int) (Math.random() + 0.5);		//ispunjavanje matrice random 0 i 1
			}
		}
		for (int[] ex : matrix) {
			System.out.println(Arrays.toString(ex));		//printanje matrice
		
		}
			//ispis rezultata, ako je true matrica ima jednak broj jedinica, ako je false onda nema
		if (isEven(matrix)) {
			System.out.println("Matrix has even number of 1s in rows and columns");
		} else
			System.out.println("Matrix doesnt have even number of 1s in row and columns");
	}
		//metoda za provjeru da svaki red i kolona ima jedna broj jedinica
	public static boolean isEven(int[][] matrix) {
		int counter = 0, sumColumn1 = 0, sumColumn2 = 0;
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sumColumn1 += matrix[j][0];		//suma prve kolone
				sumColumn2 += matrix[j][i];		//suma svake sledece kolone
			}
			if (sum(matrix[0]) == sum(matrix[i]) && sumColumn1 == sumColumn2) {		//uslov za jednak broj jedinica u koloni i redu
				counter++;
				}
		}
		boolean check = (counter == 5) ? true : false;
		return check;
	}
		//metoda koja sumira brojeve u redu
	public static int sum(int[] list) {
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		return sum;
	}
}
