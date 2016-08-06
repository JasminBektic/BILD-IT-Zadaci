package zadaci_05_08_2016;

import java.util.Random;

public class Zadatak2 {

	public static void main(String[] args) {
		Random rand = new Random();
		
		//  string karti i znakova
		String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] signs = {"Srce", "Pik", "Djetelina", "Kocka"}; 
		
		int card = rand.nextInt(cards.length);  // random karta
		int sign = rand.nextInt(signs.length);  // random znak
		
		//  ispis karte i znaka
		System.out.println("Izvucena karta je: " + cards[card] + " a znak " + signs[sign]);
	}
}
