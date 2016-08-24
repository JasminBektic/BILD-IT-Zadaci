package zadaci_24_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Find the first ten square numbers that are greater than Long.MAX_VALUE. A square number is a number in the form of n2. 
	 * For example, 4, 9, and 16 are square numbers. Find an efficient approach to run your program fast.
	 */

import java.math.BigDecimal;

public class Z2_SquareNumbers {

	public static void main(String[] args) {
		int counter = 0;
		long first = (long) Math.sqrt(Long.MAX_VALUE);		//startni broj od kojeg se pocinje brojat je korijen od max long broja
		BigDecimal num = new BigDecimal(first);
		
		while (true) {
			num = num.add(BigDecimal.ONE);				//dodati 1 broju kako bi kvadratni broj presao granicu Long max
			BigDecimal square = num.multiply(num);		//za svaki n2 koji je veci od Long max ispisati u konzoli
			System.out.println(square);
			counter++;			
			if (counter == 10) {		
				break;	
			}
		}
	}
}
