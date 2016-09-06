package zadaci_05_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the Rational class in Listing 13.13 using a new internal representation for the numerator and denominator. 
	 * Create an array of two integers as follows: private long[] r = new long[2]; Use r[0] to represent the numerator and r[1] to 
	 * represent the denominator. The signatures of the methods in the Rational class are not changed, so a client application that 
	 * uses the previous Rational class can continue to use this new Rational class without being recompiled.
	 */

public class Zadatak_1 {

	public static void main(String[] args) {
		Rational rational = new Rational(4, 2);		//New object
	    rational = rational.divide(new Rational(6, 3));
	    System.out.println(rational);			//Result
	}
}
