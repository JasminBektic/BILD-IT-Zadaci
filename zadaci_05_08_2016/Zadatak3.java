package zadaci_05_08_2016;

import java.util.Scanner;

public class Zadatak3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first string:");
		String str1 = input.nextLine();  // unos prvog stringa
		
		System.out.print("Enter the second string:");
		String str2 = input.nextLine();  // unos drugog stringa
		
		input.close();
		String prefix = "";
		
		int minLength = Math.min(str1.length(), str2.length());  // odredjivanje manjeg length-a
		
		for (int i = 0; i < minLength; i++) {
			
			if (str1.charAt(i) == str2.charAt(i)) {  
				prefix += str1.charAt(i);  // ako je su karakteri isti na istom indexu, pohraniti u prefix string
			} else
				break;
		}
		if (prefix.length() == 0) {
			System.out.println("Nema prefixa");  // ispis rezultata u slucaju da nema prefix
		} else {
			System.out.println("Prefix je: " + prefix);  // ispis rezultata u slucaju da ima prefix
		}
	}
}