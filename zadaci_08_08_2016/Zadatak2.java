package zadaci_08_08_2016;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite godinu i mjesec: ");
		int year = input.nextInt();  // unos godine
		int month = input.nextInt();  // unos mjeseca
		input.close();
		
		   // ispis rezultata
		System.out.println(findMonth(year, month));
	}
			// metoda za pronalazenje odgovarajuceg mjeseca
	public static String findMonth(int year, int month) {
		String s = "";
		switch (month) {
			case 1: s = "Januar " + year + " ima 31 dan.";
				break;
			case 2: if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 
						s = "Februar " + year + " ima 29 dana";
					else 
						s = "Februar " + year + " ima 28 dana";
				break;
			case 3: s = "Mart " + year + " ima 31 dan.";
				break;
			case 4: s = "April " + year + " ima 30 dana.";
				break;
			case 5: s = "Maj " + year + " ima 31 dan.";
				break;
			case 6: s = "Juni " + year + " ima 30 dana.";
				break;
			case 7: s = "Juli " + year + " ima 31 dan.";
				break;
			case 8: s = "Avgust " + year + " ima 31 dan.";
				break;
			case 9: s = "Septembar " + year + " ima 30 dana.";
				break;
			case 10: s = "Oktobar " + year + " ima 31 dan.";
				break;
			case 11: s = "Novembar " + year + " ima 30 dana.";
				break;
			case 12: s = "Decembar " + year + " ima 31 dan.";
				break;
			default: s = "Taj mjesec ne postoji!";
		}
		return s;
	}
}
