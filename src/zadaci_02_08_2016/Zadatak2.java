package zadaci_02_08_2016;

import java.util.Random;
import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		System.out.println("Koliko pitanja zelite?");
		int x = 1;
		do {    // restart metoda, program se restartuje sve dok input ne bude pravilan
		try {   // za slucaj da unos bude pogresan
			Scanner input = new Scanner(System.in);
			int numOfQuestions = input.nextInt();
			quiz(numOfQuestions);
			input.close();
			x = 2;
		} 
		catch (Exception e) {
			System.out.print("Pogresan unos, koristite integer!! Koliko pitanja zelite? ");
		}
	}
		while (x == 1);
	}
	
	public static void quiz(int numOfQuestions) {
		int positive = 0;
		int negative = 0;
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		for (int i = 0; i < numOfQuestions; i++) {
			int num1 = rand.nextInt(10);  
			int num2 = rand.nextInt(10);  
		  if (num2 > num1) {   // u slucaju da prvi broj bude manji od drugog
				int a = num2;
				num2 = num1;
				num1 = a;
			}
			System.out.printf("Koliko je %d - %d", num1, num2);
			int answer = input.nextInt();
		  if (num1 - num2 == answer) {
			  positive++;  // brojac tacnih odgovora
		  }
			else 
				negative++;  // brojac netacnih odgovora
		}
		System.out.println("Broj tacnih odgovora: " + positive + "\nBroj netacnih odgovora: " + negative);
	}
}
