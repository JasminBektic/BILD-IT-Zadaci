package zadaci_08_08_2016;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite godinu: ");
		int year = input.nextInt();  // unos godine
		System.out.println("Unesite prva tri slova mjeseca: ");
		String month = input.next();  // unos mjeseca
		String newMonth = month.substring(0, 1).toUpperCase() + month.substring(1);  // pretvorba prvog slova u uppercase
		input.close();
		
		   // ispis rezultata
		System.out.println(findMonth(year, newMonth));
	}
			// metoda za pronalazenje odgovarajuceg mjeseca
	public static String findMonth(int year, String month) {
		String s = "";
		switch (month) {
			case "Jan": s = "Jan " + year + " ima 31 dan.";
				break;
			case "Feb": if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 
						s = "Feb " + year + " ima 29 dana";
					else 
						s = "Feb " + year + " ima 28 dana";
				break;
			case "Mar": s = "Mar " + year + " ima 31 dan.";
				break;
			case "Apr": s = "Apr " + year + " ima 30 dana.";
				break;
			case "Maj": s = "Maj " + year + " ima 31 dan.";
				break;
			case "Jun": s = "Jun " + year + " ima 30 dana.";
				break;
			case "Jul": s = "Jul " + year + " ima 31 dan.";
				break;
			case "Avg": s = "Avg " + year + " ima 31 dan.";
				break;
			case "Sep": s = "Sep " + year + " ima 30 dana.";
				break;
			case "Okt": s = "Okt " + year + " ima 31 dan.";
				break;
			case "Nov": s = "Nov " + year + " ima 30 dana.";
				break;
			case "Dec": s = "Dec " + year + " ima 31 dan.";
				break;
			default: s = "Taj mjesec ne postoji!";
		}
		return s;
	}
}
