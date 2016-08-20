package zadaci_19_08_2016;

import java.util.Arrays;

	/*
	 * Write a method to sort a two-dimensional array using the following header: 
	 * public static void sort(int m[][]) The method performs a primary sort on rows and a secondary sort on columns.
	 */

public class Zadatak4 {

	public static void main(String[] args) {
		int[][] m = {
				{4, 2},
				{1, 7},
				{4, 5},
				{1, 2},
				{1, 1},
				{4, 1}
		};
		sort(m);
	}
		//metoda za sortiranje 2D niza
	public static void sort(int m[][]) {
		int[] temp = new int[2];
		for (int i = 0; i < m.length - 1; i++) {
			int index = i;			//pronalazenje prvog reda i kolone
			temp = m[i];
			for (int j = i; j < m.length; j++) {
				if (temp[0] > m[j][0] || temp[0] == m[j][0] && temp[1] >= m[j][1]) {	
					temp = m[j];		//novi red
					index = j;			//novi index
				}
			}
			if (index != i) {
				m[index] = m[i];
				m[i] = temp;
			}
		}
		System.out.print(Arrays.deepToString(m));	//ispis sortirane matrice
	}
}
