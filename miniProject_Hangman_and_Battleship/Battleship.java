package miniProjekat_Hangman_and_Battleship;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Battleship is a guessing game for two players. It is known worldwide as a pencil and paper game which dates from World War I. 
	 * It was published by various companies as a pad-and-pencil game in the 1930s, and was released as a plastic board game by 
	 * Milton Bradley in 1967.
	 * 
	 */

import java.util.Scanner;

public class Battleship {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		game();
	}
	
	public static void game() {
		char[][] table = new char[10][10];		//kreiranje table
		char[][] shipPos = new char[10][10];	//kreiranje niza za poziciju brodova
		shipPos(shipPos);		//nasumico postavljene pozicije
		int sum = 0;
		int count = 30;
		while (count != 0) {			//broj pokusaja, po defaultu 30
			print(table);
			System.out.println(count + " more attempts!");
			System.out.println("Enter row (0 - 9):");
			int row = check();			//unos reda
			System.out.println("Enter column (0 - 9):");
			int column = check();		//unos kolone
			if (shipPos[row][column] == '■') {	
				table[row][column] = shipPos[row][column];		//dodati karakter iz niza pozicije brodova u tabelu
				sum += '■';
			} else
				table[row][column] = 'X';
			if (sum == 163744) {			//suma svih kockica i uslov za pobjedu
				print(table);
				System.out.println("You win!");
				System.exit(0);
			}
			count--;
		}
		print(table);
		System.out.println("Computer win!");
	}
	//metoda za print tabele
	public static void print(char[][] table) {
		for (int i = 0; i < table.length; i++) {
			System.out.println(" -----------------------------------------");
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(" | " + table[i][j]);
			}
			System.out.print(" |");
			System.out.println();
		}
		System.out.println(" -----------------------------------------");
	}
	//metoda koja postavlja nasumicno rasporedjene brodice
	public static void shipPos(char[][] shipPos) {
		carrier(shipPos);
		battleship(shipPos);
		submarine(shipPos);
		destroyer(shipPos);
		patrolBoat(shipPos);
	}
	//metoda za brod carrier i njegove postavke
	public static void carrier(char[][] shipPos) {
		int size = 5;		//velicina
		int sumRow = 0, sumColumn = 0;
		boolean status = true;
		while (status) {
			int randRow = (int) (Math.random() * 6);		//nasumican index reda
			int randColumn = (int) (Math.random() * 6);		//nasumican index kolone
			int HV = (int) (Math.random() * 2);		 
			switch (HV) {
				case 0: for (int i = 0; i < size; i++) {		//horizontalna postavka
						sumRow += shipPos[randRow][randColumn + i];
						}
						if (sumRow == 0) {
							for (int i = 0; i < size; i++) {
								shipPos[randRow][randColumn + i] = '■';
							} 
							status = false;
						} else
							sumRow = 0;		
						break;
				case 1: for (int i = 0; i < size; i++) {		//vertikalna postavka
							sumColumn += shipPos[randRow + i][randColumn];
						}
						if (sumColumn == 0) {
							for (int i = 0; i < size; i++) {
								shipPos[randRow + i][randColumn] = '■';
							}
							status = false;
						} else
							sumColumn = 0;	
						break;
				}
			}
	}
	//metoda za brod battleship i njegove postavke
	public static void battleship(char[][] shipPos) {
		int size = 4;			//velicina
		int sumRow = 0, sumColumn = 0;
		boolean status = true;
		while (status) {
			int randRow = (int) (Math.random() * 7);		//nasumican index reda
			int randColumn = (int) (Math.random() * 7);		//nasumican index kolone 
			int HV = (int) (Math.random() * 2);
			switch (HV) {
			case 0: for (int i = 0; i < size; i++) {		//horizontalna postavka
					sumRow += shipPos[randRow][randColumn + i];
					}
					if (sumRow == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow][randColumn + i] = '■';
						} 
						status = false;
					} else
						sumRow = 0;		
					break;
			case 1: for (int i = 0; i < size; i++) {		//vertikalna postavka
						sumColumn += shipPos[randRow + i][randColumn];
					}
					if (sumColumn == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow + i][randColumn] = '■';
						}
						status = false;
					} else
						sumColumn = 0;	
					break;
			}
		}
	}
	//metoda za brod submarine i njegove postavke
	public static void submarine (char[][] shipPos) {
		int size = 3;
		int sumRow = 0, sumColumn = 0;
		boolean status = true;
		while (status) {
			int randRow = (int) (Math.random() * 8);
			int randColumn = (int) (Math.random() * 8);
			int HV = (int) (Math.random() * 2);
			switch (HV) {
			case 0: for (int i = 0; i < size; i++) {		//horizontalna postavka
					sumRow += shipPos[randRow][randColumn + i];
					}
					if (sumRow == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow][randColumn + i] = '■';
						} 
						status = false;
					} else
						sumRow = 0;		
					break;
			case 1: for (int i = 0; i < size; i++) {		//vertikalna postavka
						sumColumn += shipPos[randRow + i][randColumn];
					}
					if (sumColumn == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow + i][randColumn] = '■';
						}
						status = false;
					} else
						sumColumn = 0;	
					break;
			}
		}
	}
	//metoda za brod destroyer i njegove postavke
	public static void destroyer(char[][] shipPos) {
		int size = 3;
		int sumRow = 0, sumColumn = 0;
		boolean status = true;
		while (status) {
			int randRow = (int) (Math.random() * 8);
			int randColumn = (int) (Math.random() * 8);
			int HV = (int) (Math.random() * 2);
			switch (HV) {
			case 0: for (int i = 0; i < size; i++) {		//horizontalna postavka
					sumRow += shipPos[randRow][randColumn + i];
					}
					if (sumRow == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow][randColumn + i] = '■';
						} 
						status = false;
					} else
						sumRow = 0;		
					break;
			case 1: for (int i = 0; i < size; i++) {		//vertikalna postavka
						sumColumn += shipPos[randRow + i][randColumn];
					}
					if (sumColumn == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow + i][randColumn] = '■';
						}
						status = false;
					} else
						sumColumn = 0;	
					break;
			}
		}
	}
	//metoda za broj patrolBoat i njegove postavke
	public static void patrolBoat(char[][] shipPos) {
		int size = 2;
		int sumRow = 0, sumColumn = 0;
		boolean status = true;
		while (status) {
			int randRow = (int) (Math.random() * 9);
			int randColumn = (int) (Math.random() * 9);
			int HV = (int) (Math.random() * 2);
			switch (HV) {
			case 0: for (int i = 0; i < size; i++) {		//horizontalna postavka
					sumRow += shipPos[randRow][randColumn + i];
					}
					if (sumRow == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow][randColumn + i] = '■';
						} 
						status = false;
					} else
						sumRow = 0;		
					break;
			case 1: for (int i = 0; i < size; i++) {		//vertikalna postavka
						sumColumn += shipPos[randRow + i][randColumn];
					}
					if (sumColumn == 0) {
						for (int i = 0; i < size; i++) {
							shipPos[randRow + i][randColumn] = '■';
						}
						status = false;
					} else
						sumColumn = 0;	
					break;
			}
		}
	}
	//metoda za provjeru unosa i granice unosa broja
	public static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();		//unos
				while (true) {
					if (num < 0 || num > 9) {	//ako je broj manji od nule ili veci od 9 zatraziti ponovni unos
						System.out.println("Only 0 - 9 numbers are allowed, try again:");
						num = input.nextInt();
					} else
						break;
				}
				break;
			}
			catch (Exception e) {		//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();		//ciscenje inputa
			}
		}
		return num;
	}
}
