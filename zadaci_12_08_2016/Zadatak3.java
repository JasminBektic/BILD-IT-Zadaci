	/*
	 * Napisati metodu sa sljedeæim headerom: public static int isPrime(int n) 
	 * koja provjerava da li je broj prost/prime. Napsati test program koji 
	 * poziva ovu metodu i ispisuje sve proste brojeve u rasponu od 0 do 100000.
	 */
package zadaci_12_08_2016;

public class Zadatak3 {
	
	public static void main(String[] args) {
		int counter = 0;
		for (int i = 2; i <= 100000; i++) {
			if (isPrime(i) != 0) {			// ako broj nije 0, ispisi ga
				System.out.print(isPrime(i) + "\t");		// ispis prostog broja
				counter++;
			}
			if (counter == 10) {			// svakih 10 brojeva novi red
				System.out.println();
				counter = 0;
			}
		}
	}
	
		// metoda za provjeru da li je broj prost ili ne
	public static int isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {		// ako je broj djeljiv sa i, nije prost
				return n = 0;
			}
		}
		return n;
	}
}
