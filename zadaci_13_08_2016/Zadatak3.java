package zadaci_13_08_2016;

	/*
	 * Emirp brojevi (prime unazad) je nepalindromski prosti broj koji je prosti broj i kada ispišemo naopako. Na primjer, broj 17 i broj 71 su prosti 
	 * brojevi tako da su brojevi i 17 i 71 emirp brojevi. Napisati program koji ispisuje prvih 100 emirp brojeva, 10 brojeva po liniji. 
	 */

public class Zadatak3 {

	public static void main(String[] args) {
		int counter = 0;
		for (int i = 2; i < 3050; i++) {	
			if (isPrime(i) && reversePrime(i) && isPalindrome(i) == false) {	// uslov za ispis Emirp brojeva
				System.out.print(i + "\t");
				counter++;
				if (counter == 10) {			// niz od 10 brojeva zatim novi red
					System.out.println();
					counter = 0;				// reset brojaca
				}
			}
		}
	}
		// metoda koja provjerava da li je broj prost
	public static boolean isPrime(int number) {
		boolean prime = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {			// ako je broj djeljiv sa i, nije prost
				prime = false;
				break;
			}
		}
		return prime;
	}
		// metoda koja provjerava da li je i okrenuti broj prost broj
	public static boolean reversePrime(int number) {
		String str1 = "" + number;
		String str2 = new StringBuilder(str1).reverse().toString();			// okrenuti prost broj 
		boolean valide = (isPrime(Integer.parseInt(str2))) ? true : false;	// ako je okrenuti broj takodje prost broj, true
		return valide;
	}
		// metoda palindrom, za uslov Emirp brojeva
	public static boolean isPalindrome(int number) {
		String str = "" + number;
		 return str.equals(new StringBuilder(str).reverse().toString());	// vraca da li je okrenuti broj jednak prostom broju
	}
}
