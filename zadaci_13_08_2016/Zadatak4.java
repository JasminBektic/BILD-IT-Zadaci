package zadaci_13_08_2016;

	/*
	 * Palindrome prime je prosti broj koji je takoðer i palindrom. Na primjer, 131 je palindrome prime, kao i brojevi 313 i 757. 
	 * Napisati program koji ispisuje prvih 100 palindrome prime brojeva, 10 brojeva po liniji. 
	 */

public class Zadatak4 {

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 2; i < 94300; i++) {			// manuelno podesavanje :)
			if (isPrime(i) && isPalindrome(i)) {	// ako je broj prost i palindrom, printaj
				System.out.print(i + "\t");
				counter++;
				if (counter == 10) {			// niz po 10 brojeva
					System.out.println();
					counter = 0;				// restart brojaca
				}
			}
		}
	}
		// metoda koja provjerava da li je broj prost
	public static boolean isPrime(int number) {
		boolean prime = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {			// ako je djeljiv sa i, nije prost
				prime = false;
				break;
			}
		}
		return prime;
	}
		// metoda koja provjerava da li je broj palindrom
	public static boolean isPalindrome(int number) {
		String str = "" + number;
		 return str.equals(new StringBuilder(str).reverse().toString());	// eksperimentisanje sa StringBuilderom
	}
}
