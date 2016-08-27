package zadaci_27_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that randomly fills in 0s and 1s into an n-by-n matrix, prints the matrix, and finds the rows and columns with the most 1s. 
	 * (Hint: Use two ArrayLists to store the row and column indices with the most 1s.)
	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the array size n:");
		int n = check();
		int[][] num = new int[n][n];
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				num[i][j] = (int) (Math.random() + 0.5);	//unos random 0 i 1 u matricu
				System.out.print(num[i][j] + " ");		//ispis 0 i 1
			}
			System.out.println();		//novi red
		}
		largest(num);	//poziv metode
	}
	//metoda koja pronalazi red i kolonu sa najvise jedinica
	public static void largest(int[][] num) {
		ArrayList<Integer> countRow = new ArrayList<>();		//kreiranje brojaca reda i kolone
		ArrayList<Integer> countColumn = new ArrayList<>();
		int sumRow = 0, sumColumn = 0, rowMax = 0, columnMax = 0;
		for (int i = 0; i < num.length; i++) {
			sumRow = 0;
			sumColumn = 0;
			for (int j = 0; j < num[i].length; j++) {
				sumRow += num[i][j];
				sumColumn += num[j][i];
				if (rowMax < sumRow) {		//ako je max reda manji od sume, dodjeli maxu sumu
					rowMax = sumRow;
				}
				if (columnMax < sumColumn) {	//ako je max kolone manji od sume, dodjeli maxu sumu
					columnMax = sumColumn;
				}
			}
			countRow.add(sumRow);			//dodaj sumu redova u array
			countColumn.add(sumColumn);		//dodaj sumu kolona u array
		}
		System.out.print("The largest row index: ");		//uporedi max sa redovima i ispisi max broj
		for (int i = 0; i < countRow.size(); i++) {
			if (countRow.get(i) == rowMax) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.print("The largest column index: ");	//uporedi max sa kolonama i ispisi max broj
		for (int i = 0; i < countColumn.size(); i++) {
			if (countColumn.get(i) == columnMax) {
				System.out.print(i + " ");
			}
		}
	}
	//metoda za provjeru unosa
	public static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();	//unos
				break;
			}
			catch (Exception e) {		//hvatanje greske
				System.out.println("Wrong input. try again:");
				input.nextLine();
			}
		}
		return num;
	}
}
