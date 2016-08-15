package zadaci_15_08_2016;

	/*
	 * Napisati program koji sabira sljedeæu seriju 1/3 + 3/5 + 5/7 + 7/9 + 9/11 + 11/13 ..... + 95/97 + 97/99.
	 */

public class Zadatak3 {

	public static void main(String[] args) {
		double sum = 0;
		for (int i = 0; i < 97; i++,i++) {		// brojac je postavljen da broji svaki drugi broj
			sum += (1.0 + i) / (3.0 + i);		// dodajemo svaki drugi broj u formulu
		}
		System.out.println("Suma: " + sum);
	}
}
