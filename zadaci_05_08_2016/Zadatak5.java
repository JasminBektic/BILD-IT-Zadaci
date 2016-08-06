package zadaci_05_08_2016;

import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite neki string:");
		String s = input.nextLine();  // unos stringa
		input.close();
		
		//  ispis stringa i broja slova
		System.out.println("String koji ste unijeli: " + s);
		System.out.println("Vas string sadrzi " + countLetters(s) + " slova!");
	}
	
	public static int countLetters(String s) {
		int letterCounter = 0;
		char[] chars = s.toCharArray();  // konvertovanje stringa u niz karaktera
		for (char ex : chars) {
			if (Character.isLetter(ex) == true) {
				letterCounter++;  // brojac slova
			}
		}
		return letterCounter;
	}
}
