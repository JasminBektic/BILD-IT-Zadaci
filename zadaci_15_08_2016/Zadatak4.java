package zadaci_15_08_2016;

	/*
	 * Napisati metodu koja izraèunava zbir svih brojeva u cijelom broju. Koristite sljedeæi header: 
	 * public static int sumDigits(long n). Na primjer, ako pozovemo metodu i proslijedimo joj broj 234 (sumDigits(234)) 
	 * metoda treba da vrati 9. (2 + 3 + 4 = 9)
	 */

public class Zadatak4 {

	public static void main(String[] args) {
		System.out.println(sumDigits(234));
	}
	
	public static int sumDigits(long n) {
		int sum = 0;
		while (n != 0) {
			int remainder = (int)(n % 10);	// djelimo broj sa 10 i ostatak dodjeljujemo varijabli
			sum += remainder;				// svaki ostatak sumiramo
			n = n / 10;						// ponovo dijelimo broj sa deset kako bi odstranili zadnju cifru
		}
		return sum;
	}
}
