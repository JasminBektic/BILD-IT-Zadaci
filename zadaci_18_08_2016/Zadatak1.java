package zadaci_18_08_2016;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

	/*
	 * Write a program that generates 100 random integers between 0 and 9 and displays the count for each number
	 */

public class Zadatak1 {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<>();
		int rand = 0;
		for (int i = 0; i < 100; i++) {
			rand = (int) (Math.random() * 10);
			if (!map.containsKey(rand))			// ako ne sadrzi broj, dodaj tom broju key i njegovu vrijednost
				map.put(rand, 1);
			else {								// ako broj postoji, nadji njegov key i dodaj vrijednost 1
				int value = map.get(rand);
				value++;
				map.put(rand, value);
			}
		}
		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Map.Entry<Integer, Integer> entry: entrySet) {				// ispisi key i vrijednost svakog broja
			System.out.printf("Broj %d se ponovio %d puta\n", entry.getKey(), entry.getValue());
		}
	}
}
