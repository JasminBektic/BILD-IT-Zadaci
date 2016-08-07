package zadaci_06_08_2016;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		int investment = 0, numOfYears = 0;
		double yearInterest = 0;
		boolean checkInput = true;
		do {
			try {  // u slucaju pogresnog unos, program resetuje
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite iznos vase investicije:");
				investment = input.nextInt();	//unos investicije
				System.out.println("Unesite godisnju interesnu stopu: ");
				yearInterest = input.nextDouble();	//unos stope
				System.out.println("Unesite broj godina nakon kojeg biste zeljeli znati vrijednost investicije:");
				numOfYears = input.nextInt();	//unos godina
				input.close();
				checkInput = false;
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, probajte ponovo!");
			}
		} while (checkInput);
		
			// ispis rezultata
		System.out.printf("Posle %d godina vasa vrijednost investicije je %5.2f", numOfYears, 
				investmentValue(investment, yearInterest, numOfYears));
	}
	
		// metoda za izracun vrijednosti buduce investicije
	public static double investmentValue(int investment, double yearInterest, int numOfYears) {
		double monthInterest = (yearInterest / 100) / 12;
		double futureValue = investment * Math.pow((1 + monthInterest), numOfYears * 12);
			return futureValue;
	}
}
