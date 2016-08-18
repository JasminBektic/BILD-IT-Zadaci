package zadaci_18_08_2016;

import java.util.Random;

	/*
	 * Write a method that returns a random number between 1 and 54, excluding the numbers passed in the argument. The 
	 * method header is specified as follows: public static int getRandom(int... numbers)
	 */

public class Zadatak2 {

	public static void main(String[] args) {
		System.out.println(getRandom(1,2,3,4,5,6,7,8,9));	// poziv metode
	}
	
	public static int getRandom(int... numbers) {
		Random rand = new Random();
		int num = rand.nextInt(54) + 1;		// random brojevi 1-54
		for (int ex : numbers) {
			if (num == ex) {			// ako je rand broj isti kao u argumentu, prekini program
				System.out.println("Random broj je naveden u argumentu");
				System.exit(0);
			}
		}
		return num;			// vrati broj
	}
}
