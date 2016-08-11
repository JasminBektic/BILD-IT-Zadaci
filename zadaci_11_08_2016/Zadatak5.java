	/*
	 * Napisati program koji uèitava neodreðen broj cijelih brojeva, odreðuje koliko je 
	 * pozitivnih brojeva korisnik unijeo, koliko negativnih te izraèunava ukupnu sumu i 
	 * prosjek svih unesenih brojeva. (Korisnik prekida unos tako što unese nulu). Na primjer, 
	 * ukoliko korisnik unese 1 2 -1 3 0 program treba da ispiše da je broj pozitivnih 
	 * brojeva 3, negativnih brojeva 1, suma ili zbir su 5.0 a prosjek svih brojeva je 1.25.
	 */
package zadaci_11_08_2016;

import java.util.Scanner;

public class Zadatak5 {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Unesite brojeve (nula prekida unos): ");
		int pCount = 0, nCount = 0, counter = 1;
		double sum = 0;
		for (int i = 0; i < counter; i++) {
			int n = checkInput();
			sum += n;
			counter++;
			if (n == 0) {		// ako je broj nula, izadji iz petlje
				break;
			}
			int a = (n < 0) ? nCount++ : pCount++;
		}
		double average = sum / (nCount + pCount);
				// ispis rezultata 
		System.out.printf("Suma: %3.1f\nAverage: %3.2f\nPozitivnih brojeva: %d\nNegativnih brojeva: %d", sum, average, pCount, nCount);
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
				input.nextLine();
			}
		} while (check);
		return num;
	}
}
