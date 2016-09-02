package zadaci_02_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the PrintCalendar class in Listing 6.12 to display a calendar for a specified month using the Calendar 
	 * and GregorianCalendar classes. Your program receives the month and year from the command line. For example: 
	 * java Exercise13_04 5 2016
	 * You also can run the program without the year. In this case, the year is the current year. If you run the program 
	 * without specifying a month and a year, the month is the current month.
	 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Zadatak_1 {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter year:");
		int year = check();
		System.out.println("Enter month (1 - 12):");
		int month;
		while (true) {
			month = check();
			if (month < 1 || month > 12) {		//broj mora biti u granicama 1-12
				System.out.println("Only 1 - 12 numbers allowed, try again:");
				continue;
			} else
				break;
		}
		printCalendar(month, year);		//poziv metode i prikaz kalendara
	}
	
	//metoda koja ispisuje godinu i mjesec
	public static void printCalendar(int month, int year) {
		System.out.println("\t\t   " + monthName(month) + year);
		System.out.println("---------------------------------------------------");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, 1);
		int start = calendar.get(GregorianCalendar.DAY_OF_WEEK);	//prvi dan u sedmici
		for (int i = 1; i < start; i++) {			// uslov za pocetak prvog dana u sedmici
			System.out.print("\t");
		}
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			System.out.print(i + "\t");
			if ((i + start - 1) % 7 == 0) {				// uslov za ispis dana u sedmici
				System.out.println();
			}
		}
		System.out.println("\n");
	}
	
	//metoda koja odredjuje ime mjeseca
	public static String monthName(int month) { 
		String s = "";
		switch (month) {
			case 1: s = "January "; break;
			case 2: s = "February "; break;
			case 3: s = "March "; break;
			case 4: s = "April "; break;
			case 5: s = "May "; break;
			case 6: s = "June "; break;
			case 7: s = "July "; break;
			case 8: s = "August "; break;
			case 9: s = "September "; break;
			case 10: s = "October "; break;
			case 11: s = "November "; break;
			case 12: s = "December "; break;
		}
		return s;
	}
	//metoda za provjeru unosa
	public static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();		//unos
				break;
			} catch (Exception e) {			//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();
			}
		}
		return num;
	}
}