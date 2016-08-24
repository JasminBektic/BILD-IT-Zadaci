package zadaci_24_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Find the first ten numbers greater than Long.MAX_VALUE that are divisible by 5 or 6.
	 */

import java.math.BigDecimal;

public class Z5_Divisible {

	public static void main(String[] args) {
		int counter = 0;
	    BigDecimal num = new BigDecimal(Long.MAX_VALUE);
	    while (counter < 10) {					//izaci iz petlje kada brojac bude jednak 10
	    	num = num.add(BigDecimal.ONE);		//dodati 1 na vrijednost Long max
	        if (num.remainder(new BigDecimal(5)).equals(BigDecimal.ZERO) || 	//ako je broj djeljen sa 5 ili 6 nema ostatka, ispisi ga
	        	num.remainder(new BigDecimal(6)).equals(BigDecimal.ZERO)) {
	            counter++;
	            System.out.println(num);
	        }   
	    }
	}
}
