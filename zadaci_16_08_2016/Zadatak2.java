package zadaci_16_08_2016;

import java.util.Scanner;

/*
 * Napisati program koji pita korisnika da unese neki string te mu ispisuje dužinu tog stringa kao i 
 * prvo slovo stringa. 
 */

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		System.out.println("Unesite string: ");
		String str = input.nextLine();			// unos stringa
		input.close();		
		System.out.printf("Duzina stringa je: %d\nPrvo slovo: %s", str.length(), str.substring(0, 1));	// ispis rezultata
	}
}
