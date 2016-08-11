	/*
	 * Napisati program koji pita korisnika da unese broj minuta (npr. 1 milijardu) te 
	 * ispiše korisniku koliko je to u godinama i danima. Zbog jednostavnosti, pretpostavimo 
	 * da godina ima 365 dana.  
	 */
package zadaci_11_08_2016;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Zadatak4 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Unesite broj minuta: ");
		long minute = checkInput();		// unos minuta i provjera
		
		long days = TimeUnit.MINUTES.toDays(minute);	// pretvorba minuta u dane
		long year = days / 365;
		long newDays = days - year * 365;
		
		System.out.println("Godine:\tDani:");
		System.out.println(year + "\t" + newDays);		// ispis godina i dana
	}
	
			// metoda za provjeru unosa
	public static long checkInput() {
		long num = 0;
		boolean check = true;
		do {
			try {
				num = input.nextLong();
				if (num < 0) {			// broj mora biti pozitivan
					num = Math.abs(num);
				}
				check = false;
			}
			catch (Exception e) {		// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo:");
				input.nextLine();		
			}
		} while(check);
		return num;	
	}
}
