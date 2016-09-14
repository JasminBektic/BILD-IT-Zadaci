package miniProjekat_kalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class miniCalendar {

	static File file = new File("d:/jaskio.txt");
	static Scanner input = new Scanner(System.in);
	static String[] args={};
	static int year = 0, month = 0, counter = 0;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Choose option:");
		System.out.println("1: Calendar\n2: Set remainder\n3: Load remainder\n4: Exit");
		int option = input.nextInt();
	
		if (option == 1) {
			counter++;					// brojac za potvrdu na prelazak u opciju 2
			System.out.println("Enter year: ");
			year = input.nextInt();
			System.out.println("Enter month: ");
			month = input.nextInt();
			printCalendar();
			miniCalendar.main(args);		// vracanje main metode
		}
		if (option == 2 && counter == 1) {
			inputNote();
			miniCalendar.main(args);
		}
		else if (option == 2 && counter == 0) {
			System.out.println("Enter calendar first.\n");
			miniCalendar.main(args);
		}
		if (option == 3) {
			outputNote();
			miniCalendar.main(args);
		}
		if (option == 4) {
			System.exit(0);
		}		
	}
			// metoda za printanje kalendara
	public static void printCalendar() {
		System.out.println("\t\t   " + monthName(month) + year);
		System.out.println("---------------------------------------------------");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, 1);
		int start = calendar.get(GregorianCalendar.DAY_OF_WEEK);
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
			// metoda za upis podsjetnika
	public static void inputNote() throws IOException {
		
		System.out.println("Enter specific number of day to set reminder: ");
		String day = input.next();
		PrintWriter b = new PrintWriter(file);
		System.out.println("Enter your remainder: ");
		input.nextLine();						// ciscenje inputa
		String str = input.nextLine();
		b.println(day + ", " + monthName(month) + year + ": " + str); 		// format u kojem ce se sacuvati podsjetnik
		b.close();
		System.out.println("Remainder is saved.\n");
	}
				// metoda za ispis podsjetnika
	public static void outputNote() throws FileNotFoundException {
		Scanner out = new Scanner(file);
		System.out.println("Remainder: ");
		while (out.hasNext()) {
			System.out.print(out.nextLine());  			// ispis podsjetnika
		}
		System.out.println("\n");
		out.close();
	}
			// metoda za pronalazenje odgovarajuceg mjeseca
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
}
