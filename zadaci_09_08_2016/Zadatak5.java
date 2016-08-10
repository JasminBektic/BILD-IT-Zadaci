package zadaci_09_08_2016;

import java.util.Scanner;

public class Zadatak5 {
	/*
	 * Napisati metodu koja pretavara milisekunde u sate, minute i sekunde.
	 * Metoda treba da koristi sljedeæi header: public static String convertMillis(long millis).
	 * Metoda treba da vraæa vrijeme kao string u formatu sati:minute:sekunde.
	 * Na primjer convertMillis(100000) treba da vrati 0:1:40.
	 */
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Unesite broj milisekundi: ");
		long millis = checkInput();			// unos milisekundi
		System.out.println("Vrijeme je: ");
		System.out.println(convertMillis(millis));		// ispis vremena
	}
	
			// metoda za izracun vremena u formatu h:m:s
	 public static String convertMillis(long millis) {
		 int hour = 0, minute = 0, second = 0;
		 second = (int) millis / 1000;		
		 minute = second / 60;
		 second = second % 60;
		 hour = minute / 60;		
		 minute = minute % 60;		
		 return hour + " sati : " + minute + " minuta : " + second + " sekundi";	// vracanje formata h:m:s
	 }
	 
	 		// metoda za provjeru unosa
	 public static long checkInput() {
		 long num = 0;
		 boolean check = true;
		 do {
			 try {				// hvatanje greske
				 num = input.nextLong();
				 check = false;		// potvrdi izlaz iz petlje
			 }
			 catch (Exception e) {
				System.out.println("Pogresan unos, probajte ponovo"); 
				input.nextLine();		// ocisti input
			 }
		 } while (check);
		return num;
	 }
}
