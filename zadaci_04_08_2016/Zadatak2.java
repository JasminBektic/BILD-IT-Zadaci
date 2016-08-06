package zadaci_04_08_2016;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		int x = 1;
		int d1, d2, d3, d4, d5, d6, d7, d8, d9;
		d1 = d2 = d3 = d4 = d5 = d6 = d7 = d8 = d9 = 0;
	  do {  // restart programa u slucaju pogresnog unosa
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Unesite prvih 9 ISBN brojeva: ");
			d1 = input.nextInt();
			d2 = input.nextInt();
			d3 = input.nextInt();
			d4 = input.nextInt();
			d5 = input.nextInt();
			d6 = input.nextInt();
			d7 = input.nextInt();
			d8 = input.nextInt();
			d9 = input.nextInt();
			x = 0;
			input.close();
		}
		catch (Exception e) {
			System.out.println("Pogresan unos, molimo unesite ponovo svih 9 brojeva!");
		}
	  } while (x == 1);
	  
	  //  izracun desetog broja
	  int numTen = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;
	  	if (numTen == 10) {
	  		
	  		// ispis ISBN-a ako je zadnji broj 10
	  		System.out.print("ISBN broj je: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + 'X');
	  	}
	  	else
	  	System.out.print("ISBN broj je: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + numTen);
	}
}
