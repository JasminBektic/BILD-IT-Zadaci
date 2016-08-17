package zadaci_17_08_2016;

import java.util.Scanner;

	/*
	 * U javi, short vrijednost se sprema u samo 16 bita. Napisati program koji pita korisnika da unese short broj te mu ispiše svih 16 bita 
	 * za dati cijeli broj. Na primjer, ukoliko korisnik unese broj 5 - program mu ispisuje 0000000000000101
	 */

public class Zadatak3 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite short broj:");
		short num = check();
		
		System.out.println(String.format("%016d", Integer.parseInt(Integer.toBinaryString(num))));	// ispis binarnog broja
	}
		// metoda za provjeru unosa
	public static short check() {
		short num = 0;
		do {
			try {
				num = input.nextShort();	// unos
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
