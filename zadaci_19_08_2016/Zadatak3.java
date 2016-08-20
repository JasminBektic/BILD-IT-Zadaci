package zadaci_19_08_2016;

import java.util.ArrayList;

	/*
	 * Write a program that randomly fills in 0s and 1s into a 4-by-4 matrix, prints the matrix, and finds the first 
	 * row and column with the most 1s.
	 */

public class Zadatak3 {

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		int num = (int) (Math.random() + 0.5);			//random broj za prvu dodjelu broja nizu
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(num + " ");			//ispis prvog broja i svih ostalih
				matrix[i][j] = num;						//upis broja u niz
				num = (int) (Math.random() + 0.5);		//novi random broj
			}
			System.out.println();
		}
		int sumRow = 0, sumColumn = 0;
		ArrayList<Integer> row = new ArrayList<>();		//niz kolone i reda
		ArrayList<Integer> column = new ArrayList<>();	//za smjestanje broja jedinica
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sumColumn += matrix[j][i];				//suma jedinica u koloni
				sumRow += matrix[i][j];					//suma jedinica u redu
				if (j == 3) {							//kada petlja sumira 4 broja, dodaj sumu u odgovarajuci index
					row.add(sumRow);
					column.add(sumColumn);
					sumRow = 0;
					sumColumn = 0;
				}
			}
		}
		int maxR = 0, maxC = 0;
		for (int i = 0; i < row.size(); i++) {
			if (row.get(i) > maxR) {
				maxR = row.get(i);				//pronadji prvi najveci broj u redu
				}
		}
		for (int i = 0; i < column.size(); i++) {
			if (column.get(i) > maxC) {
				maxC = column.get(i);			//pronadji prvi najveci broj u koloni
				}
		}
			//ispis kolone i reda sa najvise jedinica
		System.out.println("The largest row index: " + row.indexOf(maxR));
		System.out.println("The largest column index: " + column.indexOf(maxR));
	}
}
