package zadaci_04_08_2016;

import java.util.Scanner;

public class Zadatak1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			System.out.println("Unesite broj :");
			int number = input.nextInt();  // unos broja
			input.close();

				int one = 2;  // prvi broj
				
				while (number != 1) {
					if (number % one == 0) {
						System.out.print(one + " ");  // ispis rezultata
						
						number = number / one;  // ponovo podijeli sa 2
					} else {
						
						one++;  // povecati prvi broj
					}
				}	
			}
		}