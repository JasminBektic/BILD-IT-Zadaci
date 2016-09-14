package miniProjekat_Connect4_and_TicTacToe;

	/*
	 * Connect four is a two-player board game in which the players alternately drop colored disks into a seven-column, six-row vertically suspended grid, as shown below. 
	 * The objective of the game is to connect four same-colored disks in a row, a column, or a diagonal before your opponent can do likewise. The program prompts two players 
	 * to drop a red or yellow disk alternately. In the preceding figure, the red disk is shown in a dark color and the yellow in a light color. Whenever a disk is dropped, the 
	 * program redisplays the board on the console and determines the status of the game (win, draw, or continue).
	 * 
	 * 
	 * 
	 * @author Jasmin Bektic
	 */

import java.util.Scanner;

public class ConnectFour {
	static Scanner input = new Scanner(System.in);
	static char[][] m = new char[6][7];

	public static void main(String[] args) {
		app();
	}
		//metod za pocetak igre
	public static void app() {
		int counter = 42;			//ukupni broj poteza
		while (counter != 0) {
			grid();
			player('R', "red");				//igrac1 i njegov uslov pobjede
			if (victoryCondition(328)) {
				System.out.println("The red player won!");
				grid();
				System.exit(0);
			}
			counter--;
			grid();
			player('Y', "yellow");			//igrac2 i njegov uslov pobjede
			if (victoryCondition(356)) {
				System.out.println("The yellow player won!");
				grid();
				System.exit(0);
			}
			counter--;
		}
		grid();
		System.out.println("It's a draw!");		//ispis ako je nerjeseno
	}
		//print table
	public static void grid() {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print("|" + m[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("---------------");
	}
		//uslovi za pobjedu
	public static boolean victoryCondition(int sum) {
		int sumD1 = 0, sumD2 = 0, sumRow = 0, sumColumn = 0;
		for (int i = 5; i > 2; i--) {
			for (int j = 0; j < 4; j++) {
				int index = i;
				for (int k = j; k < 4 + j; k++) {
					int kNegative = 6 - k;			//pretvaranje k u opadajuci index
					sumD1 += m[index][k];			//sume dijagonala, redova i kolona
					sumD2 += m[index][kNegative];
					sumRow += m[i][k];
					sumColumn += m[index][j];	
					index--;						//smanjujemo index za 1
				}
				if (sumD1 == sum || sumD2 == sum || sumRow == sum || sumColumn == sum) {	//suma 4 karaktera mora biti jednaka po dijagonalama, redovima ili kolonama
					return true;
				} else
					sumD1 = 0;		//reset svih suma
					sumD2 = 0;
					sumRow = 0;
					sumColumn = 0;
			}
		}
		return false;
	}
		//metoda za unos broja kolone i provjera da li je kolona puna
	public static void player(char ch, String s) {
		System.out.print("Drop a " + s + " disk at column (0–6):");
		int column = check();
		for (int i = m.length - 1; i >= 0; i--) {
			while (true) {
				if (m[0][column] == 'R' || m[0][column] == 'Y') {	//ako je kolona puna, zatrazi novi unos
					System.out.println("The column is full, try another:");
					column = check();
					} else
						break;
				}
				if (m[i][column] != 'R' && m[i][column] != 'Y') {	//uslov da se brojevi redaju jedan na drugi u koloni
					m[i][column] = ch;
					break;
				} 
			}
	}
		//metoda za provjeru unosa
	public static int check() {
		int num = 0;
		while (true) {
			try {
				while (true) {
					num = input.nextInt();
					if (num < 0 || num > 6) {	//ako broj nije od 0-6 zatraziti ponovni unos
						System.out.println("Only numbers from 0-6 are acceptable, try again:");
					} else {
						break;
					}
				}
				break;
			}
			catch (Exception e) {		//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;
	}
}
