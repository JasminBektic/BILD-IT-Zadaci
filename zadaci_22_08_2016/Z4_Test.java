package zadaci_22_08_2016;

import java.util.Scanner;

public class Z4_Test {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//unos 6 vrijednosti za 6 varijable
		System.out.println("Enter 6 values (a,b,c,d,e and f): ");
		double a = check();
		double b = check();
		double c = check();
		double d = check();
		double e = check();
		double f = check();
		
		Z4_LinearEquation eq = new Z4_LinearEquation(a, b, c, d, e, f);
		if (eq.isSolvable() == false) {			//ako je djelitelj nula jednacina nema rjesenja
			System.out.println("The equation has no solution.");
		} else
			System.out.println("X = " + eq.getX());		//ispis jednacine X i Y
			System.out.println("Y = " + eq.getY());
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
