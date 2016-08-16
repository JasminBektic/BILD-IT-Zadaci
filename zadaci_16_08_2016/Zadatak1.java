package zadaci_16_08_2016;

	/*
	 * Napisati program koji pita korisnika da unese cijeli trocifreni broj te provjerava da li je unijeti broj 
	 * palindrom. Broj je palindrom ukoliko se èita isto i sa lijeva na desno i sa desna na lijevo npr. 121, 131, itd.
	 */

import java.util.Scanner;

public class Zadatak1 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite cijeli broj:");
		int num = check();
		String s = (reversed(num) == num) ? "Broj je palindrom" : "Broj nije palindrom";
		System.out.println(s);
	}
		// metoda koja ispisuje broj naopako
	public static int reversed(int num) {
		int reverse = num % 10;
		num = num / 10;
		while (num != 0) {
			int remainder = num % 10;					// uzimamo ostatak i pohranjujemo u reverse
			num = num / 10;								// broj djelimo sa 10 kako bi odstranili zadnji broj
			reverse = reverse * 10 + remainder;			// broj naopako
		}
		return reverse;
	}
		// metoda za provjeru unosa
	public static int check() {
		int num = 0;
		do {
			try {
				num = input.nextInt();			// unos 
				break;
			}
			catch (Exception e) {				// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo");
				input.nextLine();
			}
		} while (true);
		return num;
	}
}
