package zadaci_17_08_2016;

import java.util.ArrayList;
import java.util.Scanner;

	/*
	 * Napisati program koji uèitava 10 brojeva te ispisuje koilko je jedinstvenih brojeva unijeto te sve jedinstvene brojeve koji su unijeti, 
	 * razmaknute jednim spaceom. Ukoliko se neki broj pojavljuje više puta, broj treba ispisati samo jednom.
	 */

public class Zadatak5 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Unesite 10 brojeva:");
		for (int i = 0; i < 10; i++) {				// unos 10 brojeva
			int num = check();
			if (!list.contains(num)) {				// ako ne sadrzi isti broj staviti na listu
				list.add(num);
			}
		}
		System.out.printf("Jedinstvenih brojeva ima %d a to su:\n", list.size());
		for (int ex : list) {
			System.out.println(ex);					// ispis jedinstvenih brojeva
		}
	}
		// metoda za provjeru unosa
	public static int check() {
		int num = 0;
		do {
			try {
				num = input.nextInt();		// unos
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
