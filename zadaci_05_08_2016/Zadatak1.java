package zadaci_05_08_2016;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Unesite mjesecni iznos stednje koji cete uplacivati");
		double paymentPerMonth = input.nextDouble();  // unos iznosa stednje
		
		System.out.println("Unesite broj mjeseci nakon kojeg bi zeljeli znati stanje racuna");
		int month = input.nextInt();  // unos mjeseci
		input.close();
		
		System.out.println("Posle " + month + " mjeseci, stanje na racunu je: ");
		System.out.printf("%8.3f", bankAccount(paymentPerMonth, month));  // poziv metode
	}
	
	public static double bankAccount(double paymentPerMonth, int month) {
		double base = 0.05 / 12 + 1;
		double sum = paymentPerMonth * base;
		double accountBalance = 0;
		
		if (month == 1) {
			return sum; 	// balans za prvi mjesec
		}
		for (int i = 1; i < month; i++) {
			accountBalance = (paymentPerMonth + sum) * base;  // balans za sve ostale mjesece
			sum = accountBalance;  // nova suma
		}
		return accountBalance;
	}
}
