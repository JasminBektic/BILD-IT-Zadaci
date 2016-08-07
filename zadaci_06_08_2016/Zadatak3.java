package zadaci_06_08_2016;

import java.util.Scanner;

public class Zadatak3 {
	
	public static void main(String[] args) {
		int number = 0;
		boolean checkInput = true;
		do {
			try {    //provjera unosa, ako je pogresan program se restartuje
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite broj:");
				number = input.nextInt();  //unos broja
				input.close();
				checkInput = false;
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, probaj ponovo!");
			}
		} while (checkInput);
		
		// ispis rezultata
		System.out.println(isPalindrome(number) ? "Broj je palindrom." : "Broj nije palindrom.");
	}
	
	// metoda za obrnuti broj
	public static int reverse(int number) {
		int reversedNum = 0;
		while (number != 0) {
			int remainder = number % 10;
			reversedNum = reversedNum * 10 + remainder;
			number = number / 10;
		}
		return reversedNum;
	}
	
	// metoda za provjeru da li je broj palindrom
	public static boolean isPalindrome(int number) {
		boolean palindrome = false;
		if (number == reverse(number)) {  
			palindrome = true;
		}
		return palindrome; 
	 }
}
