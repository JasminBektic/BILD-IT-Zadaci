	/*
	 * Napisati program koji ispisuje sve proste brojeve od 2 do 1000, ukljuæujuæi i 
	 * 2 i 1000. Program treba da ispiše 8 brojeva po liniji te razmak izmeðu brojeva 
	 * treba da bude jedan space.
	 */
package zadaci_11_08_2016;

public class Zadatak2 {

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 2; i <= 1000; i++) {
			if (isPrime(i)) {
				counter++;			// ako je prost broj dodaj brojacu vrijednost 1
				System.out.print(i + "\t");
				if (counter == 8) {			// svakih 8 brojeva, novi red
					counter = 0;
					System.out.println();
				}
			}
		}
		/* System.out.println(1000);  u zadatku pise ukljucujuci i broj 1000 na kraju, 
		 * posto se sat vremena mislim da li to znaci printanje broja 1000 ili je naveden 
		 * samo kao max broj, evo linija koda za svaki slucaj
		 */
		
	}
	
			// metoda za utvrdjivanje prostog broja
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
