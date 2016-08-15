package zadaci_15_08_2016;

	/*
	 * Napisati program koji igra sa protivnikom rock-paper-scissors. (papir-bunar-makaze ili tako nekako po naški) 
	 * Program nasumièno generiše brojeve 0, 1 i 2 koji predstavljaju papir, bunar i makaze. Program pita korisnika da unese 0, 1 
	 * ili 2 te mu ispisuje poruku da li je korisnik pobijedio, da li je raèunar pobijedio ili je bilo neriješeno. 
	 */

import java.util.Random;
import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		String win = "Pobijedio si", lose = "Izgubio si";
		Scanner input = new Scanner(System.in);
		System.out.println("0- Rock\n1- Scissors\n2- Paper\nUnesite jedan od ponudjenih brojeva:");
		int num = 0;
		do {
			try {
				do {
				num = input.nextInt();
				if (!(num <= 2 && num >= 0)) {				// ako broj nije 0, 1 ili 2 potreban je novi unos
					System.out.println("Unesi broj 0, 1 ili 2:");
				} else
					break;	
				} while (true);
				break;
			}
			catch (Exception e) {					// hvatanje greske
				System.out.println("Pogresan unos, probajte opet:");
				input.nextLine();
			}
		} while (true);
		input.close();
		
		int rand = new Random().nextInt(3);			// protivnikov random broj
		System.out.println("Protivnik: " + rand);
		String s = "";
		if (num == rand) {						// uslov za nerjesen rezultat
			System.out.println("Nerjeseno");
			
			// uslovi za pobjede ili poraze
		} else if (num == 0) {			
			switch (rand) {
				case 1: s = win; break;
				case 2: s = lose; break;
			}
		} else if (num == 1) {
			switch (rand) {
				case 0: s = lose; break;
				case 2: s = win; break;
			}
		} else if (num == 2) {
			switch (rand) {
				case 0: s = win; break;
				case 1: s = lose; break;
			}
		}
		System.out.println(s);				// ispis rezultata
	}
}
