package zadaci_10_08_2016;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Zadatak1 {
	/*
	 *  Napisati metodu koja vraæa broj dana u godini. Metoda koristi sljedeæi header: 
	 *  public static int numberOfDayInAYear(int year). Napisati program koji pita korisnika 
	 *  da unese poèetnu godinu, krajnju godinu te ispisuje broj dana za svaku godinu u rasponu.
	 */
	static Scanner input = new Scanner(System.in);
	static GregorianCalendar greg = new GregorianCalendar();
	
	public static void main(String[] args) {
		int startYear = 0, endYear = 0;
		System.out.println("Unesite pocetnu godinu: ");
		startYear = checkInput();
		System.out.println("Unesite krajnju godinu: ");
		endYear = checkInput();
		
		System.out.print("Dana u godini:");
		for (int i = startYear; i <= endYear; i++) {							// ispis godina 
			System.out.print("\n" + i + ": " + numberOfDayInAYear(i) + " ");	// i dana u godini
		}
	}
	
			// metoda za provjeru prestupne godine
	public static int numberOfDayInAYear(int year) {
		boolean a = greg.isLeapYear(year);		// vrati true ako je prestupna
		if (a) {
			return 366;
		}
		return 365;
	}
			// metoda za provjeru unosa
	public static int checkInput() {
		int num = 0;
		boolean check = true;
		do {
			try {
				num = input.nextInt();
				if (num < 0) {			// ako je broj negativan
					Math.abs(num);		// pretvoriti u pozitivan
				}
				check = false;
			}
			catch (Exception e) {		// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo: ");
				input.nextLine();		// ocisti input
			}
		} while (check);
		return num;
	}
}
