package zadaci_06_08_2016;

import java.util.Scanner;

public class Zadatak4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite vas string: ");
		String s = input.nextLine();  //unos stringa
		input.close();
		
		for (int i = 0; i < s.length(); i++, i++) {   //i sada racuna svaki drugi index
			System.out.print(s.charAt(i));  // ispis rezultata
		}
	}
}
