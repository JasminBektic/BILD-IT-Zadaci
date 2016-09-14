package miniProjekat_Hangman_and_Battleship;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Hangman is a paper and pencil guessing game for two or more players. One player thinks of a word, phrase or 
	 * sentence and the other tries to guess it by suggesting letters or numbers, within a certain number of guesses.
	 * The word to guess is represented by a row of dashes, representing each letter of the word. In most variants, proper 
	 * nouns, such as names, places, and brands, are not allowed. If the guessing player suggests a letter which occurs in 
	 * the word, the other player writes it in all its correct positions. If the suggested letter or number does not occur 
	 * in the word, the other player draws one element of a hanged man stick figure as a tally mark.
	 * 
	 */

import java.util.Scanner;

public class Hangman {
	static char[][] ch = {
			{'╔','═','═','═','╗',' '},
			{'║',' ',' ',' ',' ',' '},
			{'║',' ',' ',' ',' ',' '},
			{'║',' ',' ',' ',' ',' '},
			{'║',' ',' ',' ',' ',' '},
			{'╚','═','═','═','═','═'},
	};
	
	public static void main(String[] args) {
			game();
	}   
	//metoda za printanje vjesala
	public static void print() {
		for (char[] ex : ch) {
			for (char exe : ex) {
				System.out.print(exe);
			}
			System.out.println();
		}
	}
	//glavna metoda
	public static void game() {
		Scanner input = new Scanner(System.in);
		
		//lista rijeci za pogoditi
		String[] list = {"automobil", "zrikavac", "sladoled", "sok", "ventilator", "knjiga", "novcanik", "novac", "karte", "lopta", "kornjaca", 
				"laptop", "dzuboks", "bubanj", "kafa", "dorucak", "student", "zgrada", "motor", "poligon", "krastavac", "banana", "mobitel", 
				"tastatura", "monitor", "slusalice", "sijalica", "torba", "krzno", "sunce", "sudoper", "serpa", "kasika"};
		String misses = "";		//brojac promasenih slova
		int index = (int) (Math.random() * list.length); 	//random index iz liste rijeci
		int counter = 0, sumWord = 0, sumList = 0;
		char[] word = new char[list[index].length()];		//kreiranje niza rijeci i njegovo printanje
		for (int i = 0; i < word.length; i++) {
			word[i] = '_';
		}
		while (true) {
			print();
			System.out.print("Word: ");
			for (int i = 0; i < word.length; i++) {		//printanje rijeci
				System.out.print(word[i] + " ");
			}
			System.out.print("\nMisses: " + misses);	//print promasenih slova
			System.out.println("\nGuess letter:");
			char guess = input.next().charAt(0);		//unos slova
			int count = 0;
			for (int i = 0; i < list[index].length(); i++) {
				if (list[index].charAt(i) == guess) {		//broj slova u listi koji se podudara sa unesenim slovom
					word[i] = guess;						//upisati u print verziju
					count++;
				}
			}
			if (count == 0) {					//ako nije pronadjen nijedan match slova, popuniti
				misses += guess + " ";			//promasena slova i glavnu tablu
				counter++;
				missParts(counter);
			}
			//uslovi za pobjedu
			if (counter == 6) {		//ukoliko izbrojimo 6 promasenih slova, poraz i zadnji ispis tabele
				print();
				System.out.print("Word: ");
				for (int i = 0; i < word.length; i++) {
					System.out.print(word[i] + " ");
				}
				System.out.print("\nMisses: " + misses);
				System.out.println("\nYou lose, answer was: " + list[index]);
				System.exit(0);
			} else {
				for (int i = 0; i < word.length; i++) {		
					sumWord += word[i];
					sumList += list[index].charAt(i);
				}
					if (sumWord == sumList) {		//ako su iste sume, pobjeda i zadnji ispis tabele
						print();
						System.out.print("Word: ");
						for (int i = 0; i < word.length; i++) {
							System.out.print(word[i] + " ");
						}
						System.out.print("\nMisses: " + misses);
						System.out.println("\nYou win!");
						break;
					} else
						sumWord = 0;		//restart brojaca sume
						sumList = 0;
				}
		}
	}
	//metoda za dodavanje vrijednosti na glavnoj tabli
	public static void missParts(int n) {
		switch (n) {
			case 1: ch[1][4] = 'O'; break;
			case 2: ch[2][4] = '|'; break;
			case 3: ch[1][3] = 92; break;
			case 4: ch[1][5] = '/'; break;
			case 5: ch[3][3] = '/'; break;
			case 6: ch[3][5] = 92; break;
		}
	}
}
