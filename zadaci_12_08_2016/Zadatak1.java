	/*
	 * Pretpostavimo da se registarska tablica za auto sastoji od tri uppercase 
	 * karaktera i 4 broja u sljedeæem formatu AAA-1234. Napisati program koji 
	 * nasumièno generiše tablicu.
	 */
package zadaci_12_08_2016;

import java.util.Random;

public class Zadatak1 {
	
	public static void main(String[] args) {
		Random rand = new Random();			// kreiranje objekta Random
		for (int i = 0; i < 3; i++) {
			System.out.print((char) (rand.nextInt(26) + 65));	// nasumicni karakteri od A-Z
		}
		System.out.print("-");
		for (int i = 0; i < 4; i++) {
			System.out.print(rand.nextInt(10));		// nasumicni brojevi od 0-9
		}
	}
}
