package zadaci_09_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadatak4 {
	/*
	 *  Napišite program koji uèitava neodreðen broj cijelih brojeva (unos prekida nula), 
	 *  pronalazi najveæi od unijetih brojeva te ispisuje koliko se najveæi broj puta ponovio.
	 *  Na primjer, ukoliko unesemo 3 5 2 5 5 5 0 program ispisuje da je najveæi broj 5 te ispisuje
	 *  da se isti ponavlja 4 puta. 
	 */
	static int max = 0, counter1 = 1, counter2 = 0, num = 1;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Unesite brojeve (nula prekida unos): ");
		for (int i = 0; i < counter1; i++) {
			counter1++;
			num = checkInput();
			if (num > max) {		// odredi max broj
				max = num;
			}
			list.add(num);
			if (num == 0) {			// ako je unos 0, izlaz iz petlje
				input.close();
				break;
			}
		}
		printList(list);																// ispis
		System.out.printf("\nMax broj je: %d\nPonavlja se: %d puta", max, counter2);	// rezultata
	}
	
		// metoda za pronalazenje ponavljanog max broja i printanje niza
	public static void printList(ArrayList<Integer> list) {
		System.out.println("Uneseni niz je: ");
		for (int ex : list) {
			System.out.print(ex + " ");		// print niza
			if (ex == max) {
				counter2++;			// brojac ponavljanja
			}
		}
	}
	
		// metoda za provjeru unosa
	public static int checkInput() {
		int n = 0;
		boolean check = true;
		do {
			try {
				n = input.nextInt();		// unos
				check = false;
			}
			catch (InputMismatchException e) {		// hvatanje greske
				System.out.println("Pogresan unos, unesite cijeli broj: ");
				input.nextLine();		// ocisti input
			}
		} while (check);
		return n;
	}
}
