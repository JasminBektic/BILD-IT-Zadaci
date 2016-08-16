package zadaci_16_08_2016;

import java.util.Scanner;

	/*
	 * Napisati program koji pita korisnika da unese Social Security Number (SSN) u formatu DDD-DD-DDDD gdje D predstavlja broj. Program treba da provjerava 
	 * da li je broj unesešen u ispravnom formatu. Ukoliko nije, program pita korisnika da pokuša ponovo. Ukoliko jeste unešen u pravom formatu, 
	 * program završava sa radom.
	 */

public class Zadatak3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite socijalni broj: (format: DDD-DD-DDDD, D-broj):");
		do {
			String in = input.nextLine();					// unos stringa
			if (!checkSocial(in)) {
				System.out.println("Broj nije u odgovarajucem formatu, probajte ponovo:");
			} else
				System.exit(0);
		} while (true);
	}
		// metoda za ispitavanje ispravnog formata
	public static boolean checkSocial(String str) {
		StringBuilder s = new StringBuilder();
		s.append(str);
		String minus = "-";
		if (!(s.substring(3, 4).equals(minus) && s.substring(6, 7).equals(minus))) {	// uslov koji trazi da je crtica na pravom mjestu
			return false;
		}
		s.deleteCharAt(3); s.deleteCharAt(5);						// brisanje crtica
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i)) || !(s.length() == 9)) {		// uslov koji trazi da format bude nacinjen od brojeva
				return false;
			}
		}
		return true;
	}
}
