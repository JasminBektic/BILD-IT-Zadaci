package zadaci_06_08_2016;


import java.util.Scanner;

public class Zadatak5 {

	public static void main(String[] args) {
		boolean checkInput = false;
		double v = 0, a = 0;
		do {  			//u slucaju pogresnog unosa program ce se restartovati
			try {	
				Scanner input = new Scanner(System.in);
				System.out.println("Unesite brzinu u m/s: ");
				v = input.nextDouble();  // unos brzine
		
				System.out.println("Unesite ubrzanje u m/s2: ");
				a = input.nextDouble();  //unos ubrzanja
				input.close();
				checkInput = true;
			}
			catch (Exception e) {
				System.out.println("Pogresan unos, molimo probajte ponovo!");
			}
		} while (checkInput == false);
		
		double aeroLength = v * v / (2 * a);   //duzina piste
		System.out.printf("Minimalna duzina piste bi bila %5.3f metara", aeroLength);  //ispis rezultata
	}
}
