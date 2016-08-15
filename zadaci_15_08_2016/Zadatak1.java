package zadaci_15_08_2016;

	/*
	 * Napisati program koji nasumièno generiše cijeli broj izmeðu 1 i 12 te ispisuje ime 
	 * mjeseca za taj broj. (Januar za 1, Ferbruar za 2....)
	 */

import java.util.Random;

public class Zadatak1 {

	public static void main(String[] args) {
		Random rand = new Random();
		String s = "";
		switch (rand.nextInt(12) + 1) {		// random broj koji ce se upariti sa odgovarajucim mjesecom
			case 1: s = "Januar"; break;
			case 2: s = "Februar"; break;
			case 3: s = "Mart"; break;
			case 4: s = "April"; break;
			case 5: s = "Maj"; break;
			case 6: s = "Juni"; break;
			case 7: s = "Juli"; break;
			case 8: s = "Avgust"; break;
			case 9: s = "Septembar"; break;
			case 10: s = "Oktobar"; break;
			case 11: s = "Novembar"; break;
			case 12: s = "Decembar"; break;
		}
		System.out.println(s);			// ispis random mjeseca
	}
}
