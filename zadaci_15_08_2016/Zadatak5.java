package zadaci_15_08_2016;

	/*
	 * Napisati metodu koja ispisuje n x n matricu koristeæi se sljedeæim headerom: public static void printMatrix(int n). 
	 * Svaki element u matrici je ili 0 ili 1, nasumièno generisana. Napisati test program koji pita korisnika da unese broj n te mu 
	 * ispiše n x n matricu u konzoli.
	 */

import java.util.Random;
import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite cijeli broj: ");
		int n = 0;
		do {
			try {
				n = input.nextInt();		// unos broja
				break;
			}
			catch (Exception e) {			// hvatanje greske
				System.out.println("Pogresan unos, probaj opet:");
				input.nextLine();			// ciscenje inputa
			}
		} while (true);
		input.close();
		printMatrix(n);
	}
		// metoda koja printa matricu
	public static void printMatrix(int n) {
		Random rand = new Random();
		for (int i = 1; i <= n * n; i++) {		// uneseni broj pomnozen samim sobom je gornja granica
			System.out.print(rand.nextInt(2) + " ");	// printanje random broja
			if (i % n == 0) {
				System.out.println();
			}
		}
	}
}
