package zadaci_05_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Redesign and implement the Rational class in Listing 13.13 using BigInteger for the numerator and denominator.
	 */

import java.math.BigDecimal;

public class Zadatak_2 {

	public static void main(String[] args) {
		BigIntegerRational bir = new BigIntegerRational(new BigDecimal(4), new BigDecimal(2));	//New object
	    bir = bir.divide(new BigIntegerRational(new BigDecimal(6), new BigDecimal(3)));
	    System.out.println(bir);	//Print result
	}
}
