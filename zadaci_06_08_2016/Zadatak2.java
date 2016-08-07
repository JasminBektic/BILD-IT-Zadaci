package zadaci_06_08_2016;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		int minYear = 0, maxYear = 0;
		boolean checkInput = true;
		do {
			try {  //provjera da li je unos pogresan
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite min granicu godine:");
				minYear = input.nextInt();  // unos min granice
				
				System.out.println("Unesite max granicu godine:");
				maxYear = input.nextInt();  // unos max granice
				
				input.close();
				checkInput = false;
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, probaj ponovo!");
			}
		} while (checkInput);
		
			//ispis rezultata
		System.out.printf("Od %d do %d ovo su prijestupne godine:\n", minYear, maxYear);
		leapYear(minYear, maxYear);
	}
	
		//metoda za izracunavanje prijestupne godine
	public static void leapYear(int minYear, int maxYear) {
		int counter = 0;
		for (int i = minYear; i <= maxYear; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {  // uslov za prijestupnu godinu
				counter++;
				System.out.print(i + " ");
			if (counter % 10 == 0) {
				System.out.println();
				}
			}
		}
	}
}
