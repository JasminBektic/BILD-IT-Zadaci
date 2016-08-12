	/*
	 *  Napisati program koji pita korisnika da unese 3 cijela broja te 
	 *  mu ispiše ta ista tri broja u rastuæem redosljedu. Bonus: Napisati 
	 *  metodu koja prima tri cijela broja kao argumente te vraæa brojeve 
	 *  u rastuæem redosljedu. 
	 */
package zadaci_12_08_2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zadatak4 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite tri cijela broja:");
		int n1 = checkInput();		// unos i provjera brojeva
		int n2 = checkInput();
		int n3 = checkInput();
		sort(n1, n2, n3);		// poziv metode
	}
	
	public static void sort(int n1, int n2, int n3) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		System.out.println("Lista brojeva:\n" + list);	// lista unesenih brojeva
		Collections.sort(list);		// sortiranje liste
		System.out.println("Lista brojeva poredanih u rastucem redoslijedu:\n" + list);	// ispis sortirane lista
	}
		// metoda za provjeru unosa
	public static int checkInput() {
		int num = 0;
		boolean check = true;
		do {		// petlja se koristi sve dok korisnik ne unese pravilan broj
			try {
				num = input.nextInt();
				check = false;
			}
			catch (Exception e) {		// hvatanje greske
				System.out.println("Pogresan unos, porobajte ponovo:");
				input.nextLine();	// ocisti input
			}
		} while (check);
		return num;
	}
}
