package zadaci_09_08_2016;

public class Zadatak3 {
	/*
	 * Napišite program koji ispisuje sve brojeve, od 100 do 1000, 
	 * 10 brojeva po liniji, koji su djeljivi i sa 5 i sa 6. 
	 * Razmak izmeðu brojeva treba biti taèno jedan space. 
	 */
	public static void main(String[] args) {
		int counter = 0;
		for (int i = 100; i < 1000; i += 5) {		// i broji svakih 5 brojeva
			if (i % 6 == 0) {			// ako je i djeljiv sa 6, ispisi broj
				counter++;
				System.out.print(i + " ");		// ispis rezultata
			}
			if (counter == 10) {		// svakih deset brojeva, novi red
				System.out.println();
				counter = 0;			// restart brojaca
			}
		}
	}
}
