package zadaci_01_08_2016;

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();  // kreiranje liste
		boolean checkInput = true;
		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite brojeve (nula prekida unos): ");
				int counter = 1;  // counter za gornju granicu u petlji
				for (int i = 0; i < counter; i++, counter++) {
					int in = input.nextInt();
					list.add(in);  // unos brojeva u niz
					if (in == 0) {
						checkInput = false;
						input.close();
						break;
						}
					}
				}
			catch (Exception e) {
				System.out.println("Pogresan unos, probajte ponovo!");
			}
		} while (checkInput);
		
		maxNum(list);  // poziv metode
	}
			// metoda za pronalazenje maksimalnog broja u nizu i njegovo ponavljanje
	public static void maxNum(ArrayList<Integer> list) {
		int counter = 0;
		int max = 0;
		for (int ex : list) {
			if (ex > max) {
				max = ex;
				counter = 0;
			}
			if (ex == max) {
				counter++;
			}
		}				// ispis rezultata
		System.out.printf("Najveci broj je %d koji se ponavlja %d puta", max, counter);
	}
}
