package zadaci_17_08_2016;

import java.util.Scanner;

	/*
	 * Napisati program koji prima karakter te vraæa njegov Unicode. Primjer: ukoliko korisnik unese karakter E program mu vraæa 69 kao unicode za taj karakter.
	 */

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite karakter:");
		String ch = "";
		do {
			ch = input.next();
			if (ch.length() != 1) {			// ako nije jedan karakter, ponovi
				System.out.println("Samo jedan karakter potreban:");
			} else
				break;						// ako jest, izadji iz petlje
		} while (true);
		input.close();
		
		System.out.println("Unicode je: " + (int)ch.charAt(0));		// ispis unicode
	}
}
