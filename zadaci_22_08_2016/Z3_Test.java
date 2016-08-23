package zadaci_22_08_2016;

import java.util.Scanner;

public class Z3_Test {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//unos vrijednosti a, b i c
		System.out.println("Enter value for a: ");
		double a = check();
		System.out.println("Enter value for b: ");
		double b = check();
		System.out.println("Enter value for c: ");
		double c = check();
		
		Z3_QuadraticEquation eq = new Z3_QuadraticEquation(a, b, c);
		if (eq.getDiscriminant() > 0) {						//ako je diskriminant pozitivan, printati oba roots
			System.out.println("Root1: " + eq.getRoot1());
			System.out.println("Root2: " + eq.getRoot2());
		} else if (eq.getDiscriminant() == 0) {				//ako je diskriminant nula printaj jedan root
			System.out.println("Root1: " + eq.getRoot1());
		} else
			System.out.println("The equation has no roots.");	//ispis ako jednacina nema root
	}
		//metoda za provjeru unosa
	static double check() {
		double num = 0;
		while (true) {
			try {
				num = input.nextDouble();	//unos
				break;
			}
			catch (Exception e) {		//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;
	}
}
