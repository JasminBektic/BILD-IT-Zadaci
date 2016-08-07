package zadaci_01_08_2016;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		boolean checkInput = true;
		do {
			try {  // u slucaju pogresnog unosa, program reset
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite dva broja: ");
				num1 = input.nextInt();  // unos prvog broja
				num2 = input.nextInt();  // unos drugog broja
				input.close();
				checkInput = false;
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, probajte ponovo!");
			}
		} while (checkInput);
					// ispis rezultata
		System.out.printf("Najveci zajednicki djelilac izmedju %d i %d broja je: ", num1, num2);
		gcd(num1, num2);
	}
	
			// metoda za izracun najveceg zajednickog djelitelja
	public static void gcd(int num1, int num2) {
		int minNum = Math.min(num1, num2);
		int maxNum = Math.max(num1, num2);
		for (int i = minNum; i > 0; i--) {
			if (minNum % i == 0 && maxNum % i == 0) {
				System.out.println(i);
				break;
			} 
		}  
	}
}
