package zadaci_02_08_2016;

public class Zadatak5 {

	public static void main(String[] args) {
		coinFlip(200);  // poziv metode sa brojem bacanja novcica
	}
	
	public static void coinFlip(int numOfFlips) {
		int head = 0;
		int tail = 0;
		for (int i = 0; i < numOfFlips; i++) {
			int coin = (int) Math.round(Math.random());  // random dodjeljeni brojevi (0-1)
			if (coin == 1)
				head++;
			else
				tail++;
		}
		System.out.printf("Novcic je %d puta bio glava", head);   // ispis glava-pismo slucajeva
		System.out.printf("\nNovcic je %d puta bio pismo", tail);
	}
}
