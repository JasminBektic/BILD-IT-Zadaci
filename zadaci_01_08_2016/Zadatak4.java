package zadaci_01_08_2016;

import java.util.Random;

public class Zadatak4 {

	public static void main(String[] args) {
		int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;
		int[] list = new int[100];
		for (int i = 0; i < list.length; i++) {
			list[i] = new Random().nextInt(10);  // random brojevi od 0-9
		}
		for (int ex : list) {
			switch (ex) {  // brojevi iz liste rasporedjeni u brojace u odredjenim case slucajevima
				case 0: zero++;
						break;
				case 1: one++;
						break;
				case 2: two++;
						break;
				case 3: three++;
						break;
				case 4: four++;
						break;
				case 5: five++;
						break;
				case 6: six++;
						break;
				case 7: seven++;
						break;
				case 8: eight++;
						break;
				case 9: nine++;
						break;
			}
		}
						// ispis rezultata
		System.out.printf("Nula: %d\nJedinica: %d\nDvica: %d\nTrica: %d\nCetvorki: %d\nPetica: %d\nSestica: %d\nSedmica: %d\nOsmica: %d\nDevetki: %d", zero, one, two, three, four, five, six, seven, eight, nine);
	}
}
