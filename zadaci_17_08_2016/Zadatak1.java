package zadaci_17_08_2016;

import java.util.Scanner;

	/*
	 * Napisati program koji prima ASCII kod (cijeli broj izmeðu 0 i 127) te ispisuje koji je to karakter. Na primjer, 
	 * ukoliko korisnik unese 69 kao ASCII kod, program mu ispisuje da je karakter sa tim brojem karakter E.
	 */

public class Zadatak1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite broj kao ASCII kod (0 - 127):");
		int num = 0;
		do {
			num = check();			// provjera unosa
			if (num < 0 || num > 127) {		// uslova za brojeve od 0-127
				System.out.println("Samo brojevi od 0 - 127:");
			} else
				break;
		} while (true);
		System.out.println("Karakter s tim brojem je: " + (char) num);	// ispis karaktera
	}
		// metoda za provjeru unosa
	public static int check() {
		int num = 0;
		do {
			try {
				num = input.nextInt();
				break;
			}
			catch ( Exception e) {			// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo:");
				input.nextLine();			// ciscenje inputa
			}	
		} while (true);
		return num;
	}
}
