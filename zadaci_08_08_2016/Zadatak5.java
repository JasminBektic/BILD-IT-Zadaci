package zadaci_08_08_2016;

import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Unesite vas password: ");
		String password = input.next();  // unos passworda
		input.close();
		
		passCheck(password);  // poziv metode
	}
	
	public static void passCheck(String password) {
		int charCount = 0, intCount = 0;
		for (int i = 0; i < password.length(); i++) {
			char ex = password.charAt(i);
			if (Character.isDigit(ex)) {
				intCount++;  // brojac brojeva
			}
			else if (Character.isLetter(ex)) {
					charCount++;  // brojac slova
				}
			}
							// ispis rezultata ukoliko se uslovi ispune
			if ((charCount < 8) || (intCount < 2) || (password.length() != (intCount + charCount))) {
				System.out.println("Password nije validan!");   
			}													
			else												
				System.out.println("Password je validan!");
	}
}
