package zadaci_04_08_2016;

import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		int[] list = new int[100];

		int counter1 = 1;  // brojac za gornju granicu u petlji
		int counter2 = 0;  // brojac koji ce se koristiti u average formuli
		
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite brojeve koje zelite (nula zavrsava unos): ");

				while (input.hasNext()) {
				for (int i = 0; i < counter1; i++) {
					int listInput = input.nextInt();
					list[i] = listInput;   // unos brojeva
					counter1++;
					counter2++;
					if (listInput == 0) 
						break;
					} break;
				}
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, unesite brojeve ponovo!");
			} 
		
		calcNum(list, counter2);  // poziv metode
	}
	
	public static void calcNum(int[] list, int counter) {
		int aboveAverage = 0;
		double sum = 0;
		double average = 0;
		
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
			average = sum / (counter - 1);  // izracun prosjeka
		}
			for (int ex : list) {
				if (ex >= average) {
					aboveAverage++;  // brojac iznad prosjeka
				} 
			}
	
			//  ispis rezultata
		System.out.println("Prosjek: " + average);
		System.out.println("Brojeva iznad ili jednakih prosjeku ima: " + aboveAverage);
		System.out.println("Brojeva ispod prosjeka ima: " + (counter - aboveAverage - 1));
	}
}
