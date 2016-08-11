package zadaci_10_08_2016;

public class Zadatak2 {
	/*
	 * Twin prime brojevi su par prostih brojeva koji se razlikuju za 2. Na primjer, 
	 * brojevi 3 i 5 su twin primes, brojevi 5 i 7 i 11 i 13 su takoðer twin primes. 
	 * Napisati program koji ispisuje sve twin prime brojeve manje od 10000, 10 parova 
	 * po liniji. 
	 */
	public static void main(String[] args) {
		System.out.println("Twin prime brojevi manji od 10000:");
		int counter = 0;
		for (int i = 2; i < 10000; i++) {
			if (isPrime(i) && isPrime(i + 2)) {	
				counter++;				// brojac za sledeci red
				System.out.printf("%d-%-6d\t", i, (i + 2));		// ispis twin prime brojeva
				if (counter % 10 == 0) {	// svakih 10, novi red
					System.out.println();
				}
			}
		}
	}
	
			// metoda za utvrdjivanje prime broja
	public static boolean isPrime(int number) {
		boolean prime = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
}
