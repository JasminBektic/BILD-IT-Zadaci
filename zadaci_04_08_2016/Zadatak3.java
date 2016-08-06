package zadaci_04_08_2016;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
		int x = 1;
		double num1 = 0;
		double num2 = 0;
		double num3 = 0;
		
	  do {  // restart ako je pogresan unos
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Unesite prvi broj: ");
			num1 = input.nextDouble();
			
			System.out.println("Unesite drugi broj: ");
			num2 = input.nextDouble();
			
			System.out.println("Unesite treci broj ");
			num3 = input.nextDouble();
			x = 0;
			input.close();
		}
		catch (Exception e) {
			System.out.println("Pogresan unos, molimo probajte ponovo.");
	}
		} while (x == 1);
		
		displaySortedNumbers(num1, num2, num3);  // poziv metode
	}
	
	public static void displaySortedNumbers(double num1, double num2, double num3) {
		double one, two, three;
		double sum = num1 + num2 + num3;
		
		//  pronalazenje min broja
		one = Math.min(num1, num2);
		one = Math.min(one, num3);
		
		//  pronalazenje max broja
		three = Math.max(num1, num2);
		three = Math.max(three, num3);
		
		//  pronalazenje srednjeg broja
		two = sum - (one + three);
		
		System.out.printf("Redoslijed brojeva je %4.2f %4.2f %4.2f", one, two, three);
	}
}
