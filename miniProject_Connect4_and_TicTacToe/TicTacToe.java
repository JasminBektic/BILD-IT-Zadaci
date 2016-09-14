package miniProjekat_Connect4_and_TicTacToe;

	/*
	 * In a game of tic-tac-toe, two players take turns marking an available cell in a 3 * 3 grid with their respective tokens (either X or O). When one player has 
	 * placed three tokens in a horizontal, vertical, or diagonal row on the grid, the game is over and that player has won. A draw (no winner) occurs when all the cells on the grid 
	 * have been filled with tokens and neither player has achieved a win. Create a program for playing tic-tac-toe. The program prompts two players to enter an X token and O token 
	 * alternately. Whenever a token is entered, the program redisplays the board on the console and determines the status of the game (win, draw, or continue).
	 * 
	 * 
	 * 
	 * @author Jasmin Bektic
	 */

import java.util.Scanner;

public class TicTacToe  {
	static Scanner input = new Scanner(System.in);
	static String[][] m = {
			{" ", " ", " "},
			{" ", " ", " "},
			{" ", " ", " "}};

	public static void main(String[] args)  {
		app();
	}
		//redoslijed igre
	public static void app() {
		int counter = 9;			//ukupni broj poteza
		while (counter != 0) {
			grid();
			player("X");
			if (victoryCondition(264)) {		//uslov za X igraca i suma 3*X za odgovarajuca polja
				grid();
				p("X player won!");
				System.exit(0);
			}
			counter--;
			if (counter == 0) {
				break;
			}
			grid();
			player("O");
			if (victoryCondition(237)) {		//uslov za O igraca
				grid();
				p("O player won!");
				System.exit(0);
			}
			counter--;
		}
		grid();
		p("It's a draw!");		//u slucaju nerjesenog rezultata
	}
		//print trenutnih pozicija
	public static void grid() {
		p("-------------");
		p("| " + m[0][0] + " | " + m[0][1] + " | " + m[0][2] + " |");
		p("-------------");
		p("| " + m[1][0] + " | " + m[1][1] + " | " + m[1][2] + " |");
		p("-------------");
		p("| " + m[2][0] + " | " + m[2][1] + " | " + m[2][2] + " |");
		p("-------------");
	}
		//metoda za unos pozicije X ili O
	public static void player(String s) {
		while (true) {
			p("Enter a row (0, 1, or 2) for player " + s + ":");
			int row = check();
			p("Enter a column (0, 1, or 2) for player " + s + ":");
			int column = check();
			if (m[row][column].trim().isEmpty()) {			//ocisti whitespace i onda provjeri length
				m[row][column] = s;
				break;
			} else
				p("That field is already occupied, try another one.");
			}
	}
		//metoda koja provjera uslove za pobjedu
	public static boolean victoryCondition(int sum) {
		int sumColumn, sumRow;
		int sumD1 = m[0][0].charAt(0) + m[1][1].charAt(0) + m[2][2].charAt(0);	//suma dvaju
		int sumD2 = m[2][0].charAt(0) + m[1][1].charAt(0) + m[0][2].charAt(0);	//dijagonala
		if (sum - sumD1 == 0 || sum - sumD2 == 0) {		//uslov za dijagonale
			return true;
		}
		for (int i = 0; i < m.length; i++) {
			sumColumn = sum;			//pocetne vrijednosti
			sumRow = sum;
			for (int j = 0; j < m[i].length; j++) {
				sumRow -= m[i][j].charAt(0);		
				sumColumn -= m[j][i].charAt(0);
			}
			if (sumRow == 0 || sumColumn == 0) {	//uslov za tri polja u nizu
				return true;
			} 
		}
		return false;
	}
		//metoda za provjeru unosa
	public static int check() {
		int num = 0;
		while (true) {
			try {
				while (true) {
					num = input.nextInt();
					if (num < 0 || num > 2) {	//ako broj nije 0,1 ili 2 zatraziti ponovni unos
						p("Only 0, 1 and 2 are acceptable, try again:");
					} else {
						break;
					}
				}
				break;
			}
			catch (Exception e) {		//hvatanje greske
				p("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;
	}
		//skracenica za print
	public static void p(Object... args) {
		  System.out.println(args[0]);
		}
}
