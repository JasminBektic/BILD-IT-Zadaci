package zadaci_19_08_2016;

import java.util.Arrays;

	/*
	 * Suppose the weekly hours for all employees are stored in a two-dimensional array. Each row records an 
	 * employee’s seven-day work hours with seven columns. For example, the following array stores the work hours 
	 * for eight employees. Write a program that displays employees and their total hours in decreasing order of 
	 * the total hours.
	 */

public class Zadatak1 {

	public static void main(String[] args) {
		int[][] list = {	
				{2, 4, 3, 4, 5, 8, 8},
				{7, 3, 4, 3, 3, 4, 4},
				{3, 3, 4, 3, 3, 2, 2},
				{9, 3, 4, 7, 3, 4, 1},
				{3, 5, 4, 3, 6, 3, 8},
				{3, 4, 4, 6, 3, 4, 4},
				{3, 7, 4, 8, 3, 8, 4},
				{6, 3, 5, 9, 2, 7, 9}
		};
		sort(list);		//poziv metode i ispis rezultata
	}
	
	public static void sort(int[][] list) {
		int[] row = new int[7];
		int counter = 0;
		for (int i = 0; i < list.length; i++) {
			System.out.print("Employee" + i + "  ");
			for (int j = 0; j < row.length; j++) {
				row[j] = list[i][j];			//izdvajanje svakog reda
				counter++;
				if (counter == 7) {
					Arrays.sort(row);			//sortiranje reda u rastucem redoslijedu
					for (int k = row.length - 1; k >= 0; k--) 
						System.out.print(row[k] + " ");		//ispis reda u opadajucem redoslijedu
						counter = 0;			//restart brojaca
				}
			}
			System.out.println();
		}
	}
}
