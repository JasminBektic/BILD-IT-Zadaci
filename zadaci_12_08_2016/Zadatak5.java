	/*
	 * Napisati program koji uèitava cijele brojeve u rasponu od 1 do 100 
	 * te broji i ispisuje koliko je koji broj puta unijet. Pretpostavimo 
	 * da nula prekida unos brojeva. Ukoliko unesemo sljedeæi niz brojeva 
	 * 2 5 6 23 42 58 2 6 0 program nam ispisuje da se broj 2 ponavlja 2
	 *  puta, broj 5 jednom, broj 6 2 puta, broj 23 jednom, itd.
	 */
package zadaci_12_08_2016;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Zadatak5 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<>();
		System.out.println("Unesite brojeve: ");
		int counter = 1;
		for (int i = 0; i < counter; i++) {
			int key = checkInput();
			if (key == 0) {			// ako je broj nula, prekini unos
				break;
			}
			counter++;
			if (!map.containsKey(key)) {		// ako ne sadrzi broj, dodaj tom broju key i njegovu vrijednost
				map.put(key, 1);
			}
			else {					// ako broj postoji, nadji njegov key i dodaj vrijednost 1
				int value = map.get(key);
				value++;
				map.put(key, value);
			}
		}
		
		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();		// dodaj sve unose u set
		for (Map.Entry<Integer, Integer> entry: entrySet) {				// uzimanje vrijednosti i keya iz svakog unosa
			System.out.printf("Broj %d se ponovio %d puta\n", entry.getKey(), entry.getValue());
		}
	}
			// metoda za provjeru unosa
	public static int checkInput() {
		int num = 0;
		boolean check = true;
		do {
			try {
				num = input.nextInt();	// unos
				check = false;
			}
			catch (Exception e) {		// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo:");
				input.nextLine();	// ocist input
			}
		} while (check);
		return num;
	}
}
