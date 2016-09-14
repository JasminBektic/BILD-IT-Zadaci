package miniProjekat_Craps_and_CreditCards;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Craps is a popular dice game played in casinos. Write a program to play a variation of the game, as follows:
	 * Roll two dice. Each die has six faces representing values 1, 2, …, and 6, respectively. Check the sum of the 
	 * two dice. If the sum is 2, 3, or 12 (called craps), you lose; if the sum is 7 or 11 (called natural), you win; 
	 * if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is established. Continue to roll the dice until 
	 * either a 7 or the same point value is rolled. If 7 is rolled, you lose. Otherwise, you win.
	 */

import java.util.Random;
import java.util.Scanner;

public class Craps {
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();

	public static void main(String[] args) {
		menuEN();			
	}
	
		// Opcija1, igra pocinje
	public static void crapsEN() {
		int dice1 = rand.nextInt(6) + 1;						// bacanje kockica
		int dice2 = rand.nextInt(6) + 1;
		int sum = dice1 + dice2;
		System.out.printf("You rolled %d and %d\n", dice1, dice2);
		if (sum == 2 || sum == 3 || sum == 12) {					// uslovi za prvi krug igre
			System.out.println("No candies for you today, you lose");
		} else if (sum == 7 || sum == 11) {
			System.out.println("Magnificent!! You win");
		} else if ((sum >= 4 && sum <= 6) || (sum >= 8 && sum <= 10)) {
			System.out.println("Point is " + sum);
			restartEN();
			pointEN(sum);
		}
	}
	
		// Metoda koja predstavlja nastavak igre kada se dostigne Point
	public static void pointEN(int number) {		
		do {
			int dice1 = rand.nextInt(6) + 1;					// ponovno bacanje kockica
			int dice2 = rand.nextInt(6) + 1;
			System.out.printf("Dice shows that you rolled %d and %d\n", dice1, dice2);
			if (dice1 + dice2 == 7) {							// uslovi koji odredjuju pobjednika
				System.out.println("Unfortunately, you lose this one");
				break;
			}
			if (dice1 + dice2 == number) {
				System.out.println("Tremendous!! You win!");
				break;
			}
			restartEN();
		} while (true);
	}
	
		// Metoda koja se koristi kao restart opcija, kada se dostigne Point
	public static boolean restartEN() {		
		int num = 0;
		System.out.println("\nRoll again or khmm.. be chicken?\n1- Roll like a man!\n2- Exit");
		do {
			num = check();
			if (num != 1 && num != 2) {							// u slucaju da se ne unese broj 1 ili 2
				System.out.println("Don't be knave, enter option 1 or 2:");
			} else
				break;
		} while (true);
		if (num == 2) {
			System.exit(0);
		}
		return true;
	}
		
		// Metoda za provjeru unosa
	public static int check() {
		int num = 0;
		boolean check = true;
		do {
			try {
				num = input.nextInt();
				if (num < 0) {
					num = Math.abs(num);
				}
				check = false;
			}
			catch (Exception e) {						// hvatanje greske i ispis da je unos pogresan
				System.out.println("You know it's wrong input, try again mate:");
				input.nextLine();
			}
		} while (check);
		return num;
	}
	
		// Opcija2, izbor jezika
	public static void chooseLangEN() {
		System.out.println("1- English\n2- Bosnian/Croatian/Serbian");
		int num = 0;
		do {
			num = check();
			if (num != 1 && num != 2) {
				System.out.println("Don't be knave, enter option 1 or 2:");
			} else
				break;
		} while (true);
		if (num == 1) {
			menuEN();
		} else if (num == 2) {
			menuBS();
		}
	}
	
		// Opcija3 koja ispisuje instrukcije i pravila igre
	public static void howToEN() {
		System.out.println("--INSTRUCTIONS--");
		System.out.println("Roll two dice. Each die has six faces representing values 1, 2, …, and 6, respectively.\n "
				+ "Check the sum of the two dice. If the sum is 2, 3, or 12 (called craps), you lose; if the sum is 7 or\n"
				+ " 11 (called natural), you win; if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is\n "
				+ "established. Continue to roll the dice until either a 7 or the same point value is rolled. If 7 is\n "
				+ "rolled, you lose. Otherwise, you win.\n");
		System.out.println("\nPress 0 to go back...");
		do {
			int num = check();
			if (num != 0) {									// ako broj nije nula, dati upozorenje
				System.out.println("My lord, you need to press 0 (z-e-r-o) to go back. Now do it:");
			} else
				break;
		} while (true);
		menuEN();
	}
	
		// Izbornik igre, sadrzi 4 opcije
	public static void menuEN() {
		System.out.println("\n****Welcome****");
		System.out.println("\n1- Play\n2- Choose Language\n3- How To Play\n4- Exit");
		int num = check();
		switch (num) {					// izbor opcije
			case 1: crapsEN(); break;
			case 2: chooseLangEN(); break;
			case 3: howToEN(); break;
			case 4: System.exit(0);
		}
	}
	
		// Ostatak koda je isti kao i gore, samo sto je print preveden na naski :)
		// kako bi igra imala izbornik jezika u opcijama
	public static void crapsBS() {
		int dice1 = rand.nextInt(6) + 1;
		int dice2 = rand.nextInt(6) + 1;
		int sum = dice1 + dice2;
		System.out.printf("Nakon bacenih kockica brojevi su %d i %d\n", dice1, dice2);
		if (sum == 2 || sum == 3 || sum == 12) {
			System.out.println("Nazalost, izgubio si.");
		} else if (sum == 7 || sum == 11) {
			System.out.println("Bravo, pobijedio si!");
		} else if ((sum >= 4 && sum <= 6) || (sum >= 8 && sum <= 10)) {
			System.out.println("Point je " + sum);
			restartBS();
			pointBS(sum);
		}
	}
	
	public static void pointBS(int number) {		
		do {
			int dice1 = rand.nextInt(6) + 1;
			int dice2 = rand.nextInt(6) + 1;
			System.out.printf("Kockice su pale na broj %d i %d\n", dice1, dice2);
			if (dice1 + dice2 == 7) {
				System.out.println("Nazalost, izgubio si.");
				break;
			}
			if (dice1 + dice2 == number) {
				System.out.println("Bravo, pobijedio si!");
				break;
			}
			restartBS();
		} while (true);
	}
	
	public static boolean restartBS() {		
		int num = 0;
		System.out.println("\nBaci kockice ponovo ili?\n1- Baci kockice!\n2- Izadji");
		do {
			num = check();
			if (num != 1 && num != 2) {
				System.out.println("Morate unijeti broj 1 ili 2:");
			} else
				break;
		} while (true);
		if (num == 2) {
			System.exit(0);
		}
		return true;
	}
	
	public static void chooseLangBS() {
		System.out.println("1- Engleski\n2- Bosanski/Hrvatski/Srpski");
		int num = 0;
		do {
			num = check();
			if (num != 1 && num != 2) {
				System.out.println("Morate unijeti broj 1 ili 2:");
			} else
				break;
		} while (true);
		if (num == 1) {
			menuEN();
		} else if (num == 2) {
			menuBS();
		}
	}
	
	public static void howToBS() {
		System.out.println("--UPUTE--");
		System.out.println("Baci kockice. Svaka kockica ima 6 strana koje daju vrijednosti 1,2,3,4,5 i 6.\n "
				+ "Saberi vrijednosti dvaju kockica. Ako je suma 2,3 ili 12 izgubio si, ako je suma 7 ili 11 onda si\n "
				+ "pobijedio. Ako je suma drugih vrijednosti kao naprimjer 4,5,6,8,9 ili 10 onda biljezimo taj broj i\n "
				+ "nazivamo ga point broj. Nastavljamo bacati kockice sve dok ne dobijemo 7 ili point broj. Ako dobijemo\n "
				+ "broj 7, partija je izgubljena. Ako je point broj, pobjeda.\n");
		System.out.println("\nUnesite nulu kako bi se vratili nazad...");
		do {
			int num = check();
			if (num != 0) {
				System.out.println("Morate upisati nulu kako bi se vratili nazad:");
			} else
				break;
		} while (true);
		menuBS();
	}
	
	public static void menuBS() {
		System.out.println("\n****Dobrodosli****");
		System.out.println("\n1- Pocni Igru\n2- Izaberi Jezik\n3- Kako se igra\n4- Izlaz");
		int num = check();
		switch (num) {
			case 1: crapsBS(); break;
			case 2: chooseLangBS(); break;
			case 3: howToBS(); break;
			case 4: System.exit(0);
		}
	}
}
