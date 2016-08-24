package zadaci_24_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Find the first ten numbers with 50 decimal digits that are divisible by 2 or 3.
	 */

import java.math.BigDecimal;

public class Z1_Divisible {

	public static void main(String[] args) {
		String s = "1";
		for (int i = 0; i < 49; i++) {		//kreiranje prvog broja sa 50 cifri
			s = s + "0";
		}
		BigDecimal num = new BigDecimal(s);
		int counter = 0;
		while (counter < 10) {		
			if (num.remainder(new BigDecimal(2)).equals(BigDecimal.ZERO) || 	//broj mora biti djeljiv sa
				num.remainder(new BigDecimal(3)).equals(BigDecimal.ZERO)) {		//2 ili 3
				counter++;
				System.out.println(num);		//ako je djeljiv sa 2 ili 3, ispisi
			}
			num = num.add(BigDecimal.ONE);		//dodajemo 1 na broj u stringu
		}
	}
}
