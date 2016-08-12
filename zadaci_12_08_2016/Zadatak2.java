	/*
	 * Napisati program koji pita korisnika da unese dva cijela, pozitivna 
	 * broja te ispisuje najveæi i najmanji zajednièki djelilac za ta dva broja.
	 */
package zadaci_12_08_2016;

import java.util.Scanner;

public class Zadatak2 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite dva broja: ");
		int n1 = checkInput();			// unos brojeva
		int n2 = checkInput();
		int minN1 = Math.min(n1, n2);			// odredi manji i veci broj
		int minN2 = Math.max(n1, n2);
		System.out.printf("Najveci zajednicki djelilac je: %d\nNajmanji zajednicki sadrzalac je: %d", gcd(minN1, minN2), lci(minN1, minN2));	// ispis rezultata
	}
			// metoda za pronalazenje najveceg zajednickog djelitelja
	public static int gcd(int num1, int num2) {
		int num = 0;
		for (int i = num1; i > 0; i--) {
			if (num1 % i == 0 && num2 % i == 0) {		// ako su brojevi djeljeni sa "i" bez ostatka, vrati metodi
				num = i;
				break;
			} 
		}
		return num;
	}
			// metoda za pronalezenje najmanjeg zajednickog sadrzaoca
	public static int lci(int num1, int num2) {
		int num = 0;
		for (int i = (num1*num2); i >= num2; i--) {	
			if (i % num1 == 0 && i % num2 == 0) {		// ako je "i" djeljen i sa prvim i sa drugim brojem bez ostatka, vrati metodi
				num = i;
			}
		}
		return num;	
	}
			// metoda za provjeru unosa
	public static int checkInput() {
		int num = 0;
		boolean check = true;
		do {
			try {
				num = input.nextInt();		// unos
				check = false;
			}
			catch (Exception e) {		// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo:");
				input.nextLine();		// ocisti input
			}
		} while (check);
		return num;
	}
}
