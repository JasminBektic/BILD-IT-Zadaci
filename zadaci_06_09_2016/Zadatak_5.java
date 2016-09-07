package zadaci_06_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a recursive method to compute the following series: m(i) = 1/2 + 2/3 +... + i/i + 1 
	 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
	 */

public class Zadatak_5 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("m(" + i + ")= " + sum(i));		//Printing m(i) (i = 1,2...10)
		}
	}
	
	/* Recursive method for finding sum of numbers mentioned in description */ 
	public static double sum(int i) {
		if (i == 0) {
			return 0;
	    }
		return sum(i - 1) + (i / (i + 1.0));
	}
}