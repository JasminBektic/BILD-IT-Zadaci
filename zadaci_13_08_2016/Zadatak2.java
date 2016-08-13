package zadaci_13_08_2016;

import java.util.Scanner;

	/*
	 * Napišite metodu sa sljedeæim headerom koja vraæa naopako ispisan broj koji joj je proslijeðen kao argument: 
	 * public static void reverse(int number). Na primjer, reverse(3456) treba da vrati 6543. Napisati program koji 
	 * pita korisnika da unese neki cijeli broj te mu vrati isti ispisan naopako. 
	 */

public class Zadatak2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter number:");
		int number = checkInput();			// unos i provjera broja
		System.out.println("Reversed:");
		reverse(number);					// poziv metode i prikaz broja ispisanog unazad
	}
	
	public static void reverse(int number) {
		while (number != 0) {
			int remainder = number % 10;	// broj djelimo sa 10 i ostatak ispisujemo
			System.out.print(remainder);
			number = number / 10;			// novi broj bez ostatka
		}
	}
		// metoda koja provjerava unos
	public static int checkInput() {
		int num = 0;
		boolean check = true;
		do {							// petlja je aktivna sve dok unos ne bude ispravan
			try {
				num = input.nextInt();
				if (num < 0) {			// ako je broj negativan, pretvoriti u pozitivan
					num = Math.abs(num);
				}
				check = false;
			}
			catch (Exception e) {			// hvatanje greske i ispis za ponovni unos
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		} while (check);
		return num;
	}
}
