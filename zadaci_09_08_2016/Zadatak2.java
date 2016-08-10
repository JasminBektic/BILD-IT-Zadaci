package zadaci_09_08_2016;

import java.util.Scanner;

public class Zadatak2 {
	/*
	 * Great circle distance predstavlja udaljenost izmeðu dvije taèke na 
	 * površine sfere. Neka nam (x1, y1) i (x2, y2) predstavljaju geografsku 
	 * širinu i dužinu dvije taèke. Great circle distance izmeðu ove dvije 
	 * taèke može biti izraèunata koristeæi se sljedeæom formulom: 
	 * d = radius * arccos (sin(x1) X sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2)). 
	 * Napisati program koij pita korisnika da unese geografsku širinu i dužinu u 
	 * stepenima dvije taèke na površini zemlje te mu ispisuje great circle distance. 
	 * Prosjeèni radius zemlje je 6.371.01 km. Stepene koje korisnik unese trebamo 
	 * promijeniti u radianse koristeæi se Math.toRadians metodom jer Java trigonometrijske 
	 * metode koriste radianse. Širina i dužina u ovoj formuli se odnose na zapad i sjever. 
	 * Koristimo negativne vrijednosti da oznaèimo istok i jug. 
	 */
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Unesite koordinate prve tacke (u stepenima): ");
		double x1 = checkInput();		// provjera unos
		x1 = Math.toRadians(x1);		// pretvorba u radijane
		double y1 = checkInput();
		y1 = Math.toRadians(y1);
		System.out.println("Unesite koordinate druge tacke (u stepenima): ");
		double x2 = checkInput();
		x2 = Math.toRadians(x2);
		double y2 = checkInput();
		y2 = Math.toRadians(y2);
		
		gsd(x1, y1, x2, y2);		// poziv metode
	}
	
		// metoda za izracun udaljenost izmedju dvije tacke
	public static void gsd(double x1, double y1, double x2, double y2) {
		double radius = 6371.01;
		double d = radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));	// formula za izracun udaljenosti
		System.out.printf("Udaljenost: %5.2f km", d);		// ispis rezultata
	}
	
		// metoda za provjeru unosa
	public static double checkInput() {
		double num = 0;
		boolean check = true;
		do {
			try {
				num = input.nextInt();		// unos
				check = false;
			}
			catch (Exception e) {		// hvatanje greske
				System.out.println("Pogresan unos, probajte ponovo:");
				input.nextLine();		// ocisti input
			}
		} while (check);
		return num;
	}
}
