package zadaci_13_08_2016;

import java.util.Scanner;

	/*
	 * Pretpostavimo da kupujemo rižu ili neki drugi proizvod u dva razlièita pakovanja. Želimo napisati program koji uporeðuje cijene ta 
	 * dva pakovanja. Program pita korisnika da unese težinu i cijenu oba pakovanja te ispisuje koje pakovanje ima bolju cijenu.
	 */

public class Zadatak5 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		p("Enter weight and price of first product:");
		double prod1 = checkInput() / checkInput();		// unos tezine i cijene, te racunanje odnosa 
		p("Enter weight and price of second product:");
		double prod2 = checkInput() / checkInput();		
		
		if (prod1 > prod2) {					
			p("Product1 have better price");
		} else if (prod1 == prod2) {
			p("They have same price");
		} else
			p("Product2 have better price");
	}
		// metoda koja provjerava unos
	public static double checkInput() {
		double num = 0;
		boolean check = true;
		do {						// petlja je aktivna dok unos ne bude ispravan
			try {
				num = input.nextDouble();
				if (num < 0) {				// ako je broj negativan, pretvori ga u pozitivan
					num = Math.abs(num);
				}
				check = false;
			}
			catch (Exception e) {			// hvatanje greske
				p("Wrong input, try again:");
				input.nextLine(); 			// ciscenje inputa
			}
		} while (check);
		return num;
	}
		// metoda koja sluzi kao skracenica za print
	public static void p(Object... args) {
		  System.out.println(args[0]);
		}
}
