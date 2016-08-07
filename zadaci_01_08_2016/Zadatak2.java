package zadaci_01_08_2016;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		int vowelCounter = 0;
		int consonantCounter = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite vas string:");
		String s = input.nextLine().toLowerCase();  // unos stringa i pretvorba u mala slova
		input.close();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {  // da eliminisemo ako nije slovo 
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'u' || s.charAt(i) == 'o') {
					vowelCounter++;  // brojac samoglasnika
				}
				else
					consonantCounter++;
			}
		}
				// ispis rezultata
		System.out.printf("Broj samoglasnika je %d a suglasnika %d", vowelCounter, consonantCounter);
	}
}
